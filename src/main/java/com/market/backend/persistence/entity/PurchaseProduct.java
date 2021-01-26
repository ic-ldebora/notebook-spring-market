package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
  @JoinColumn(
      name = "id",
      insertable = false,
      updatable = false
  )
  private Purchase purchase;

  @ManyToOne
  @JoinColumn(
      name = "id",
      insertable = false,
      updatable = false
  )
  private Product product;
}
