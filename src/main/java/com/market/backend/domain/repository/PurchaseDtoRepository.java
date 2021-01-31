package com.market.backend.domain.repository;

import com.market.backend.domain.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

  List<PurchaseDto> getAll();

  Optional<List<PurchaseDto>> getByClient(String clientId);

  PurchaseDto save(PurchaseDto purchaseDto);
}
