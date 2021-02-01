package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
@NoArgsConstructor
public class PurchaseProduct {

  @EmbeddedId
  private PurchaseProductPk id;

  private Integer quantity;

  private Double total;

  private Boolean status;

  @ManyToOne
  @MapsId("purchaseId")
  @JoinColumn(
      name = "purchaseId",
      insertable = false,
      updatable = false
  )
  private Purchase purchase;

  @ManyToOne
  @JoinColumn(
      name = "productId",
      insertable = false,
      updatable = false
  )
  private Product product;
}
