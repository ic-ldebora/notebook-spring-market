package com.market.backend.persistence.crud;

import com.market.backend.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository
    extends CrudRepository<Purchase, Long> {

  Optional<List<Purchase>> findByClientId(String clientId);
}
