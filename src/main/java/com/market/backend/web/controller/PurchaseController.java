package com.market.backend.web.controller;

import com.market.backend.domain.PurchaseDto;
import com.market.backend.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

  @Autowired
  private PurchaseService purchaseService;

  @GetMapping("/all")
  public ResponseEntity<List<PurchaseDto>> getAll() {
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/client/{id}")
  public ResponseEntity<List<PurchaseDto>> getByClientId(@PathVariable("id") String clientId) {
    return purchaseService.getByClient(clientId)
        .map(purchaseDtoList -> new ResponseEntity<>(purchaseDtoList, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<PurchaseDto> save(@RequestBody PurchaseDto purchaseDto) {
    return new ResponseEntity<>(purchaseService.save(purchaseDto), HttpStatus.OK);
  }
}
