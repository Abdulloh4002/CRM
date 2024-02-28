package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.returnDocItems.ReqReturnDocItemsDTO;
import org.example.marketapplication.dto.returnDocItems.ResReturnDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.ReturnDocItems;
import org.example.marketapplication.entity.ReturnDocument;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.ReturnDocumentRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReturnDocItemsMapper implements MainMapper<ReqReturnDocItemsDTO, ResReturnDocItemsDTO, ReturnDocItems> {

    @Autowired
    protected StoreProductRepository storeProductRepository;
    @Autowired
    protected ReturnDocumentRepository returnDocumentRepository;


    @Mapping(target = "product", expression = "java(findProductById(returnDocItemsDTO.getProduct()))")
    @Mapping(target = "document", expression = "java(findDocumentById(returnDocItemsDTO.getDocument()))")
    public abstract ReturnDocItems toEntity(ReqReturnDocItemsDTO returnDocItemsDTO);


    protected ReturnDocument findDocumentById(Integer id){
        return returnDocumentRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Document not found"));
    }
    protected StoreProduct findProductById(Integer id) {
        return storeProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}