package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.IncomingProductsDTO;
import org.example.marketapplication.entity.IncomingProducts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomingProductsMapper extends EntityMapper<IncomingProductsDTO, IncomingProducts> {
}
