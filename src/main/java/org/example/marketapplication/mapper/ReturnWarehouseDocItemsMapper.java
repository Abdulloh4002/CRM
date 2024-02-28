package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.marketapplication.dto.returnWarehouseDocItems.ReqReturnWarehouseDocItemsDTO;
import org.example.marketapplication.dto.returnWarehouseDocItems.ResReturnWarehouseDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.ReturnWarehouseDocItems;
import org.example.marketapplication.entity.ReturnWarehouseDocument;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.ReturnWarehouseDocumentRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReturnWarehouseDocItemsMapper implements MainMapper<ReqReturnWarehouseDocItemsDTO, ResReturnWarehouseDocItemsDTO, ReturnWarehouseDocItems> {

    @Autowired
    protected StoreProductRepository storeProductRepository;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected ReturnWarehouseDocumentRepository returnWarehouseDocumentRepository;


    @Mapping(target = "storeProduct", expression = "java(findStoreProductById(returnWarehouseDocItemsDTO.getStoreProduct()))")
    @Mapping(target = "product", expression = "java(findProductById(returnWarehouseDocItemsDTO.getProduct()))")
    @Mapping(target = "document", expression = "java(findDocumentById(returnWarehouseDocItemsDTO.getDocument()))")
    public abstract ReturnWarehouseDocItems toEntity(ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO);


    protected ReturnWarehouseDocument findDocumentById(Integer id){
        return returnWarehouseDocumentRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Document not found"));
    }
    protected StoreProduct findStoreProductById(Integer id) {
        return storeProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("StoreProduct not found"));
    }
    protected Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

}