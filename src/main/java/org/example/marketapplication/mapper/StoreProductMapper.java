package org.example.marketapplication.mapper;


import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.entity.StoreProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreProductMapper extends EntityMapper<StoreProductDTO, StoreProduct> {
}