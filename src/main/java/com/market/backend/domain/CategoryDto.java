package com.market.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

  private Long id;

  private String category;

  private boolean active;
}
