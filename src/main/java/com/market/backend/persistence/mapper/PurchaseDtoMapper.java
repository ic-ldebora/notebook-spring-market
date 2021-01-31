package com.market.backend.persistence.mapper;

import com.market.backend.domain.PurchaseDto;
import com.market.backend.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseDtoMapper {

  @Mapping(source = "paymentMethod", target = "halfPayment")
  @Mapping(source = "state", target = "status")
  @Mapping(source = "itemList", target = "purchaseProductList")
  PurchaseDto toPurchaseDto(Purchase purchase);

  List<PurchaseDto> toPurchaseDtoList(List<Purchase> purchaseList);

  @InheritInverseConfiguration
  @Mapping(target = "client", ignore = true)
  Purchase toPurchase(PurchaseDto purchaseDto);
}
