package com.market.backend.persistence.mapper;

import com.market.backend.domain.ProductDto;
import com.market.backend.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {CategoryDtoMapper.class}
)
public interface ProductDtoMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "categoryId", target = "categoryId")
  @Mapping(source = "salePrice", target = "salePrice")
  @Mapping(source = "stockQuantity", target = "stock")
  @Mapping(source = "status", target = "active")
  @Mapping(source = "category", target = "categoryDto")
  ProductDto toProductDto(Product product);

  List<ProductDto> toProductDtoList(List<Product> productList);

  @InheritInverseConfiguration
  @Mapping(target = "barcode", ignore = true)
  Product toProduct(ProductDto productDto);
}
