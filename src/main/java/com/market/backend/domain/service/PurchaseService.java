package com.market.backend.domain.service;

import com.market.backend.domain.PurchaseDto;
import com.market.backend.domain.repository.PurchaseDtoRepository;
import com.market.backend.persistence.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

  @Autowired
  private PurchaseDtoRepository purchaseDtoRepository;

  public List<PurchaseDto> getAll() {
    return purchaseDtoRepository.getAll();
  }

  public Optional<List<PurchaseDto>> getByClient(String clientId) {
    return purchaseDtoRepository.getByClient(clientId);
  }

  public PurchaseDto save(PurchaseDto purchaseDto) {
    return purchaseDtoRepository.save(purchaseDto);
  }
}
