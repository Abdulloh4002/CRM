package org.example.marketapplication.mapper;


import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.priceDTO.ReqPriceDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PriceMapper implements MainMapper<ReqPriceDTO, ResPriceDTO, Price> {
    @Autowired
    private ProductRepository productRepository;

    @Mapping(target = "product", expression = "java(findProductById(priceDTO.getProduct()))")
    public  abstract Price toEntity(ReqPriceDTO priceDTO);


    protected Product findProductById(Integer id){
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
    }
}