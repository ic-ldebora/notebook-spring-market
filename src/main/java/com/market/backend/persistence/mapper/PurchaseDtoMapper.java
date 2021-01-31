package com.market.backend.persistence.mapper;

import com.market.backend.domain.PurchaseDto;
import com.market.backend.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {PurchaseItemDtoMapper.class}
)
public interface PurchaseDtoMapper {

  @Mapping(source = "halfPayment", target = "paymentMethod")
  @Mapping(source = "status", target = "state")
  @Mapping(source = "purchaseProductList", target = "itemList")
  PurchaseDto toPurchaseDto(Purchase purchase);

  List<PurchaseDto> toPurchaseDtoList(List<Purchase> purchaseList);

  @InheritInverseConfiguration
  @Mapping(target = "client", ignore = true)
  Purchase toPurchase(PurchaseDto purchaseDto);
}
