package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;
import org.example.marketapplication.dto.sellDocItemsDTO.ResSellDocItemsDTO;
import org.example.marketapplication.entity.SellDocItems;
import org.example.marketapplication.entity.SellPrice;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.SellPriceRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SellDocItemsMapper implements MainMapper<ReqSellDocItemsDTO, ResSellDocItemsDTO, SellDocItems> {

    @Autowired
    protected StoreProductRepository storeProductRepository;

    @Autowired
    protected SellPriceRepository priceRepository;

    @Mapping(target = "price", expression = "java(findSellPriceById(sellDocItemsDTO.getPrice()))")
    @Mapping(target = "product", expression = "java(findStoreProductById(sellDocItemsDTO.getStoreProduct()))")
    public abstract SellDocItems toEntity(ReqSellDocItemsDTO sellDocItemsDTO);

    protected SellPrice findSellPriceById(Integer id) {
        return priceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Price not found"));
    }

    protected StoreProduct findStoreProductById(Integer id) {
        return storeProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("StoreProduct not found"));
    }
}