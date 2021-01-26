package com.market.backend.persistence.mapper;

import com.market.backend.domain.CategoryDto;
import com.market.backend.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "description", target = "category")
  @Mapping(source = "status", target = "active")
  CategoryDto toCategoryDto(Category categoryDto);

  @InheritInverseConfiguration
  @Mapping(target = "productList", ignore = true)
  Category toCategory(CategoryDto categoryDto);
}
