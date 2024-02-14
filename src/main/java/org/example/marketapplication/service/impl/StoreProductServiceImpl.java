package org.example.marketapplication.service.impl;

import jakarta.persistence.Entity;
import lombok.*;
import org.example.marketapplication.dto.storeDTO.ReqStoreProductDTO;
import org.example.marketapplication.dto.storeDTO.ResStoreProductDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.mapper.StoreProductMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.StoreProductService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import java.util.List;

@Service
@Data
public class StoreProductServiceImpl implements StoreProductService {
    private final StoreProductRepository repository;
    private final StoreProductMapper mapper;

    @Override
    public ResStoreProductDTO getStoreProductById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResStoreProductDTO> getAllStoreProducts() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResStoreProductDTO createStoreProduct(ReqStoreProductDTO storeDTO) {
        StoreProduct storeProduct = mapper
                .toEntity(storeDTO);

        return mapper
                .toDTO(repository
                        .save(storeProduct));
    }

    @Override
    public ResStoreProductDTO updateStoreProduct(Integer id, ReqStoreProductDTO storeDTO) {
        StoreProduct storeProduct = repository.getReferenceById(id);

        return mapper
                .toDTO(repository
                        .save(storeProduct));
    }

    @Override
    public void deleteStoreProduct(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
