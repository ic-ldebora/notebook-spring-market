package com.market.backend.persistence;

import com.market.backend.domain.ProductDto;
import com.market.backend.domain.repository.ProductDtoRepository;
import com.market.backend.persistence.crud.ProductCrudRepository;
import com.market.backend.persistence.entity.Product;
import com.market.backend.persistence.mapper.ProductDtoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDtoRepository {

  private ProductCrudRepository productCrudRepository;
  private ProductDtoMapper productDtoMapper;

  @Override
  public List<ProductDto> getAll() {

    final List<Product> productList
        = (List<Product>) productCrudRepository.findAll();

    return productDtoMapper.toProductDtoList(productList);
  }

  @Override
  public Optional<List<ProductDto>> getByCategory(Long categoryId) {

    final List<Product> productList = productCrudRepository
        .findByCategoryIdOrderByNameAsc(categoryId);

    return Optional.of(productDtoMapper
        .toProductDtoList(productList));
  }

  @Override
  public Optional<List<ProductDto>> getScarceProducts(Integer quantity) {
    final Optional<List<Product>> productList = productCrudRepository
        .findByStockQuantityLessThanAndStatus(quantity, Boolean.TRUE);

    return productList.map(productList1 -> productDtoMapper
        .toProductDtoList(productList1));
  }

  @Override
  public Optional<ProductDto> getProduct(Long id) {
    return productCrudRepository.findById(id)
        .map(product -> productDtoMapper.toProductDto(product));
  }

  @Override
  public ProductDto save(ProductDto productDto) {
    return productDtoMapper.toProductDto(productCrudRepository
        .save(productDtoMapper.toProduct(productDto)));
  }

  @Override
  public void delete(Long id) {
    productCrudRepository.deleteById(id);
  }
}
