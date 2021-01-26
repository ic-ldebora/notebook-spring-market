package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String clientId;

  private LocalDateTime date;

  private String halfPayment;

  private String comment;

  private String status;

  @ManyToOne
  @JoinColumn(
      name = "id",
      insertable = false,
      updatable = false
  )
  private Client client;

  @OneToMany(mappedBy = "product")
  private List<PurchaseProduct> purchaseProductList;
}
