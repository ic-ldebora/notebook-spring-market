package com.market.backend.persistence.crud;

import com.market.backend.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository
    extends CrudRepository<Product, Long> {

  List<Product> findByCategoryIdOrderByNameAsc(Long categoryId);

  Optional<List<Product>> findByStockQuantityLessThanAndStatus(
      Integer stockQuantity, Boolean status);
}
