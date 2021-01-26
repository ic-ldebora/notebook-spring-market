package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class PurchaseProductPk implements Serializable {

  private Long purchaseId;

  private Long productId;
}
