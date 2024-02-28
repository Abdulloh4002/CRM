package org.example.marketapplication.mapper;


import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.sellPriceDTO.ReqSellPriceDTO;
import org.example.marketapplication.dto.sellPriceDTO.ResSellPriceDTO;
import org.example.marketapplication.entity.SellPrice;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.StoreProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SellPriceMapper implements MainMapper<ReqSellPriceDTO, ResSellPriceDTO, SellPrice> {
    @Autowired
    protected StoreProductRepository storeProductRepository;

    @Mapping(target = "product", expression = "java(findProductById(priceDTO.getProduct()))")
    public  abstract SellPrice toEntity(ReqSellPriceDTO priceDTO);


    protected StoreProduct findProductById(Integer id){
        return storeProductRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
    }
}