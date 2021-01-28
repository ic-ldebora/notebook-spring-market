package com.market.backend.web.controller;

import com.market.backend.domain.ProductDto;
import com.market.backend.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  public List<ProductDto> getAll() {
    return productService.getAll();
  }

  public Optional<ProductDto> getProduct(Long id) {
    return productService.getProduct(id);
  }

  public Optional<List<ProductDto>> getByCategory(Long categoryId) {
    return productService.getByCategory(categoryId);
  }

  public ProductDto save(ProductDto productDto) {
    return productService.save(productDto);
  }

  public Boolean delete(Long id) {
    return productService.delete(id);
  }
}
