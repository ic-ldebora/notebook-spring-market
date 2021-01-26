package com.market.backend.domain.repository;

import com.market.backend.domain.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductDtoRepository {

  List<ProductDto> getAll();

  Optional<List<ProductDto>> getByCategory(Long categoryId);

  Optional<List<ProductDto>> getScarceProducts(Integer quantity);

  Optional<ProductDto> getProduct(Long id);

  ProductDto save(ProductDto productDto);

  void delete(Long id);
}
