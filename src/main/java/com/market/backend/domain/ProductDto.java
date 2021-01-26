package com.market.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

  private Long id;

  private String name;

  private Long categoryId;

  private Double salePrice;

  private Integer stock;

  private Boolean active;

  private CategoryDto categoryDto;
}
