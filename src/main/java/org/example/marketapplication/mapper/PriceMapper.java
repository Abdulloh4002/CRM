package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.PriceDTO;
import org.example.marketapplication.entity.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceDTO, Price> {
}
