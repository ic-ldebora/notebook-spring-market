package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Long categoryId;

  private String barcode;

  private BigDecimal salePrice;

  private Integer stockQuantity;

  private Boolean status;

  @ManyToOne
  @JoinColumn(
      name = "id",
      insertable = false,
      updatable = false
  )
  private Category category;
}
