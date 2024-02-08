package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.ProductDTO;
import org.example.marketapplication.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
}
