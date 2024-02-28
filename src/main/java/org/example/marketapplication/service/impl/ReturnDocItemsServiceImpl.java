package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.returnDocItems.ReqReturnDocItemsDTO;
import org.example.marketapplication.dto.returnDocItems.ResReturnDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.ReturnDocItems;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.mapper.ReturnDocItemsMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.ReturnDocItemsRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.ReturnDocItemsService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReturnDocItemsServiceImpl implements ReturnDocItemsService {
    private final ReturnDocItemsRepository repository;
    private final ReturnDocItemsMapper mapper;
    private final StoreProductRepository storeProductRepository;


    @Override
    public ResReturnDocItemsDTO getReturnDocItemById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResReturnDocItemsDTO> getAllReturnDocItems() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResReturnDocItemsDTO createReturnDocItem(ReqReturnDocItemsDTO returnDocItemsDTO) {
        ReturnDocItems returnDocItems = mapper
                .toEntity(returnDocItemsDTO);

        StoreProduct storeProduct = storeProductRepository.getReferenceById(returnDocItemsDTO.getProduct());
        storeProduct.setAmount(storeProduct.getAmount()+returnDocItemsDTO.getAmount());
        storeProductRepository.save(storeProduct);
        return mapper
                .toDTO(repository
                        .save(returnDocItems));
    }

    @Override
    public ResReturnDocItemsDTO updateReturnDocItem(Integer id, ReqReturnDocItemsDTO ReturnDocItemsDTO) {
        ReturnDocItems returnDocItems = repository.getReferenceById(id);
        return mapper.toDTO(repository.save(returnDocItems));
    }

    @Override
    public void deleteReturnDocItem(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    @Override
    public List<ResReturnDocItemsDTO> findAllByDocument(Integer id) {
        return mapper.toListDTO(repository.findAllByDocumentId(id));
    }
}
