package com.market.backend.domain.service;

import com.market.backend.domain.ProductDto;
import com.market.backend.persistence.ProductRepository;
import com.market.backend.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<ProductDto> getAll() {
    return productRepository.getAll();
  }

  public Optional<ProductDto> getProduct(Long id) {
    return productRepository.getProduct(id);
  }

  public Optional<List<ProductDto>> getByCategory(Long categoryId) {
    return productRepository.getByCategory(categoryId);
  }

  public ProductDto save(ProductDto productDto) {
    return productRepository.save(productDto);
  }

  public Boolean delete(Long id) {
//    return getProduct(id).map(productDto -> {
//      productRepository.delete(productDto.getId());
//      return Boolean.TRUE;
//    }).orElse(Boolean.FALSE);

    if (getProduct(id).isPresent()) {
      productRepository.delete(id);
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
