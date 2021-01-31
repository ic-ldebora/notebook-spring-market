package com.market.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PurchaseItemDto {

  private Long productId;

  private Integer quantity;

  private BigDecimal total;

  private Boolean active;
}
