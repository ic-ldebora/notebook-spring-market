package com.market.backend.persistence.mapper;

import com.market.backend.domain.PurchaseItemDto;
import com.market.backend.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {ProductDtoMapper.class}
)
public interface PurchaseItemDtoMapper {

  @Mapping(source = "id.productId", target = "productId")
  @Mapping(source = "status", target = "active")
  PurchaseItemDto toPurchaseDto(PurchaseProduct purchaseProduct);

  @InheritInverseConfiguration
  @Mapping(target = "purchase", ignore = true)
  @Mapping(target = "product", ignore = true)
  @Mapping(target = "id.purchaseId", ignore = true)
  PurchaseProduct toPurchaseProduct(PurchaseItemDto purchaseItemDto);
}
