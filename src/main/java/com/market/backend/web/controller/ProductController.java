package com.market.backend.web.controller;

import com.market.backend.domain.ProductDto;
import com.market.backend.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public List<ProductDto> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<ProductDto> getProduct(@PathVariable("id") Long id) {
    return productService.getProduct(id);
  }

  @GetMapping("/category/{id}")
  public Optional<List<ProductDto>> getByCategory(@PathVariable("id") Long categoryId) {
    return productService.getByCategory(categoryId);
  }

  @PostMapping("/save")
  public ProductDto save(@RequestBody ProductDto productDto) {
    return productService.save(productDto);
  }

  @DeleteMapping("/delete/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return productService.delete(id);
  }
}
