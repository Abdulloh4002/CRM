package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ResIncomingProductsDTO;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class IncomingProductsMapper implements MainMapper<ReqIncomingProductsDTO, ResIncomingProductsDTO, IncomingProducts> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Mapping(target = "price", expression = "java(findPriceById(incomingProductsDTO.getPrice()))")
    @Mapping(target = "product", expression = "java(findProductById(incomingProductsDTO.getProduct()))")
    public abstract IncomingProducts toEntity(ReqIncomingProductsDTO incomingProductsDTO);

    protected Price findPriceById(Integer id) {
        return priceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Price not found"));
    }

    protected Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Products not found"));
    }
}