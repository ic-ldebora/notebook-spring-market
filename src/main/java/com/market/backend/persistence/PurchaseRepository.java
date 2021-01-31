package com.market.backend.persistence;

import com.market.backend.domain.PurchaseDto;
import com.market.backend.domain.repository.PurchaseDtoRepository;
import com.market.backend.persistence.crud.PurchaseCrudRepository;
import com.market.backend.persistence.entity.Purchase;
import com.market.backend.persistence.mapper.PurchaseDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseDtoRepository {

  @Autowired
  private PurchaseCrudRepository purchaseCrudRepository;

  @Autowired
  private PurchaseDtoMapper purchaseDtoMapper;

  @Override
  public List<PurchaseDto> getAll() {
    return purchaseDtoMapper
        .toPurchaseDtoList((List<Purchase>) purchaseCrudRepository
            .findAll()
        );
  }

  @Override
  public Optional<List<PurchaseDto>> getByClient(String clientId) {
    return purchaseCrudRepository.findByClientId(clientId)
        .map(purchase -> purchaseDtoMapper.toPurchaseDtoList(purchase));
  }

  @Override
  public PurchaseDto save(PurchaseDto purchaseDto) {

    final Purchase purchase = purchaseDtoMapper
        .toPurchase(purchaseDto);

    purchase.getPurchaseProductList()
        .forEach(purchaseProduct -> purchaseProduct
            .setPurchase(purchase));

    return purchaseDtoMapper.toPurchaseDto(purchaseCrudRepository
        .save(purchase));
  }
}
