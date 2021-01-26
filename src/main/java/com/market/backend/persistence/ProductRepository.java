package com.market.backend.persistence;

import com.market.backend.persistence.crud.ProductCrudRepository;
import com.market.backend.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }

  public List<Product> getByCategory(Long categoryId) {
    return productCrudRepository
        .findByCategoryIdOrderByNameAsc(categoryId);
  }

  public Optional<List<Product>> getScarce(Integer quantity) {
    return productCrudRepository.
        findByStockQuantityLessThanAndStatus(
            quantity,
            Boolean.TRUE
        );
  }

  public Optional<Product> getProduct(Long id) {
    return productCrudRepository.findById(id);
  }

  public Product save(Product product) {
    return productCrudRepository.save(product);
  }

  public void delete(Long id) {
    productCrudRepository.deleteById(id);
  }
}
