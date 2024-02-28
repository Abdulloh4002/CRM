package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreDocItems;
import org.example.marketapplication.entity.StoreDocument;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.StoreDocumentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreDocItemsMapper implements MainMapper<ReqStoreDocItemsDTO, ResStoreDocItemsDTO, StoreDocItems> {

    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected StoreDocumentRepository storeDocumentRepository;


    @Mapping(target = "product", expression = "java(findProductById(storeDocItemsDTO.getProduct()))")
    @Mapping(target = "document", expression = "java(findDocumentById(storeDocItemsDTO.getDocument()))")
    public abstract StoreDocItems toEntity(ReqStoreDocItemsDTO storeDocItemsDTO);


    protected StoreDocument findDocumentById(Integer id){
        return storeDocumentRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Document not found"));
    }
    protected Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}