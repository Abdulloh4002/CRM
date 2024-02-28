package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreDocItems;
import org.example.marketapplication.mapper.StoreDocItemsMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.StoreDocItemsRepository;
import org.example.marketapplication.service.StoreDocItemsService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StoreDocItemsServiceImpl implements StoreDocItemsService {
    private final StoreDocItemsRepository repository;
    private final StoreDocItemsMapper mapper;
    private final ProductRepository productRepository;


    @Override
    public ResStoreDocItemsDTO getStoreDocItemById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResStoreDocItemsDTO> getAllStoreDocItems() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResStoreDocItemsDTO createStoreDocItem(ReqStoreDocItemsDTO storeDocItemsDTO) {
        StoreDocItems storeDocItems = mapper
                .toEntity(storeDocItemsDTO);

        Product product = productRepository.getReferenceById(storeDocItemsDTO.getProduct());
        if(product.getTotalAmount()<storeDocItems.getAmount()){
            throw new EntityTypeException("The amount is less than the actual amount","StoreProduct");
        }else{
            product.setTotalAmount(product.getTotalAmount()-storeDocItemsDTO.getAmount());
            productRepository.save(product);
        }
        return mapper
                .toDTO(repository
                        .save(storeDocItems));
    }

    @Override
    public ResStoreDocItemsDTO updateStoreDocItem(Integer id, @org.jetbrains.annotations.NotNull ReqStoreDocItemsDTO StoreDocItemsDTO) {
        StoreDocItems storeDocItems = repository.getReferenceById(id);
        return mapper.toDTO(repository.save(storeDocItems));
    }

    @Override
    public void deleteStoreDocItem(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    @Override
    public List<ResStoreDocItemsDTO> findAllByDocument(Integer id) {
        return mapper.toListDTO(repository.findAllByDocumentId(id));
    }
}
