package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.mapper.StoreProductMapper;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.StoreProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StoreProductServiceImpl implements StoreProductService {
    private final StoreProductRepository repository;
    private final StoreProductMapper mapper;

    @Override
    public StoreProductDTO getStoreProductById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<StoreProductDTO> getAllStoreProducts() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public StoreProductDTO createStoreProduct(StoreProductDTO storeDTO) {
        StoreProduct storeProduct = mapper
                .toEntity(storeDTO);

        return mapper
                .toDTO(repository
                        .save(storeProduct));
    }

    @Override
    public StoreProductDTO updateStoreProduct(Integer id, StoreProductDTO storeDTO) {
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
