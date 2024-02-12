package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.priceDTO.ReqPriceDTO;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapping;

import java.util.List;

public interface MainMapper<RQ, RS, E>{
    RS toDTO(E e);
    E toEntity(RQ rq);
    List<RS> toListDTO(List<E> es);
    List<E> toListEntity(List<RQ> rq);

}
