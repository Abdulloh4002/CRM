package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.returnWarehouseDocItems.ResReturnWarehouseDocItemsDTO;
import org.example.marketapplication.dto.returnWarehouseDocItems.ReqReturnWarehouseDocItemsDTO;
import org.example.marketapplication.dto.returnWarehouseDocItems.ResReturnWarehouseDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.ReturnWarehouseDocItems;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.mapper.ReturnWarehouseDocItemsMapper;
import org.example.marketapplication.mapper.ReturnWarehouseDocItemsMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.ReturnWarehouseDocItemsRepository;
import org.example.marketapplication.repository.ReturnWarehouseDocItemsRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.ReturnWarehouseDocItemsService;
import org.example.marketapplication.service.ReturnWarehouseDocItemsService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReturnWarehouseDocItemsServiceImpl implements ReturnWarehouseDocItemsService {
    private final ReturnWarehouseDocItemsRepository repository;
    private final ReturnWarehouseDocItemsMapper mapper;
    private final StoreProductRepository storeProductRepository;
    private final ProductRepository productRepository;
     

    @Override
    public ResReturnWarehouseDocItemsDTO getReturnWarehouseDocItemById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResReturnWarehouseDocItemsDTO> getAllReturnWarehouseDocItems() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResReturnWarehouseDocItemsDTO createReturnWarehouseDocItem(ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO) {
        ReturnWarehouseDocItems returnWarehouseDocItems = mapper
                .toEntity(returnWarehouseDocItemsDTO);

        StoreProduct storeProduct = storeProductRepository.getReferenceById(returnWarehouseDocItemsDTO.getProduct());
        storeProduct.setAmount(storeProduct.getAmount()+returnWarehouseDocItemsDTO.getAmount());
        storeProductRepository.save(storeProduct);
        return mapper
                .toDTO(repository
                        .save(returnWarehouseDocItems));
    }

    @Override
    public ResReturnWarehouseDocItemsDTO updateReturnWarehouseDocItem(Integer id, ReqReturnWarehouseDocItemsDTO ReturnWarehouseDocItemsDTO) {
        ReturnWarehouseDocItems returnWarehouseDocItems = repository.getReferenceById(id);
        return mapper.toDTO(repository.save(returnWarehouseDocItems));
    }

    @Override
    public void deleteReturnWarehouseDocItem(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    @Override
    public List<ResReturnWarehouseDocItemsDTO> findAllByDocument(Integer id) {
        return mapper.toListDTO(repository.findAllByDocumentId(id));
    }
}
