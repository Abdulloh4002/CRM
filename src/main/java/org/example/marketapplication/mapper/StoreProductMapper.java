package org.example.marketapplication.mapper;


import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.storeDTO.ReqStoreProductDTO;
import org.example.marketapplication.dto.storeDTO.ResStoreProductDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreProductMapper implements MainMapper<ReqStoreProductDTO, ResStoreProductDTO, StoreProduct> {
    @Autowired
    protected ProductRepository productRepository;

    @Mapping(target = "product", expression = "java(findProductById(storeDTO.getProduct()))")
    public  abstract StoreProduct toEntity(ReqStoreProductDTO storeDTO);


    protected Product findProductById(Integer id){
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
    }
}