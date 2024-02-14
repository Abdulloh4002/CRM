package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ResIncomingProductsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreDocItems;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreDocItemsMapper implements MainMapper<ReqStoreDocItemsDTO, ResStoreDocItemsDTO, StoreDocItems> {

    @Autowired
    protected ProductRepository productRepository;


    @Mapping(target = "product", expression = "java(findProductById(storeDocItemsDTO.getProduct()))")
    public abstract StoreDocItems toEntity(ReqStoreDocItemsDTO storeDocItemsDTO);

    protected Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}