package com.market.backend.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {

  @Id
  private String id;

  private String firstName;

  private String lastName;

  private Long cellphone;

  private String address;

  private String email;

  @OneToMany(mappedBy = "client")
  private List<Purchase> purchaseList;
}
