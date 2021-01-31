package com.market.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PurchaseDto {

  private Long id;

  private String clientId;

  private LocalDateTime date;

  private String paymentMethod;

  private String comment;

  private String state;

  private List<PurchaseItemDto> itemList;
}
