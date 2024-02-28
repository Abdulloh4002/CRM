package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.acceptDocItemsDTO.ReqAcceptDocItemsDTO;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;
import org.example.marketapplication.entity.AcceptDocItems;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.repository.DocumentRepository;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AcceptDocItemsMapper implements MainMapper<ReqAcceptDocItemsDTO, ResAcceptDocItemsDTO, AcceptDocItems> {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected PriceRepository priceRepository;

    @Autowired
    protected DocumentRepository documentRepository;
    @Mapping(target = "document", expression = "java(findDocumentById(acceptDocItemsDTO.getDocument()))")
    @Mapping(target = "price", expression = "java(findPriceById(acceptDocItemsDTO.getPrice()))")
    @Mapping(target = "product", expression = "java(findProductById(acceptDocItemsDTO.getProduct()))")
    public abstract AcceptDocItems toEntity(ReqAcceptDocItemsDTO acceptDocItemsDTO);

    protected Price findPriceById(Integer id) {
        return priceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Price not found"));
    }

    protected Document findDocumentById(Integer id){
        return documentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Document Not Found"));
    }

    protected Product findProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}