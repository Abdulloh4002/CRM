package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;
import org.example.marketapplication.dto.sellDocItemsDTO.ResSellDocItemsDTO;
import org.example.marketapplication.entity.SellDocItems;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.mapper.SellDocItemsMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.SellDocItemsRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.SellDocItemsService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SellDocItemsServiceImpl implements SellDocItemsService {
    private final SellDocItemsRepository repository;
    private final SellDocItemsMapper mapper;
    private final ProductRepository productRepository;
    private final StoreProductRepository storeProductRepository;

    @Override
    public ResSellDocItemsDTO getSellDocItemById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResSellDocItemsDTO> getAllSellDocItems() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResSellDocItemsDTO createSellDocItem(ReqSellDocItemsDTO sellDocItemsDTO) {
        SellDocItems sellDocItems = mapper
                .toEntity(sellDocItemsDTO);

        if (sellDocItems.getAmount()>storeProductRepository.getReferenceById(sellDocItemsDTO.getProduct()).getAmount()){
            throw new EntityTypeException("Not enough amount of storeProduct","StoreProduct");
        }else {
            StoreProduct storeProduct = storeProductRepository.getReferenceById(sellDocItemsDTO.getProduct());
            storeProduct.setAmount(storeProduct.getAmount()- sellDocItemsDTO.getAmount());
            storeProductRepository.save(storeProduct);
        }
        return mapper
                .toDTO(repository
                        .save(sellDocItems));
    }

    @Override
    public ResSellDocItemsDTO updateSellDocItem(Integer id, ReqSellDocItemsDTO sellDocItemsDTO) {
        SellDocItems sellDocItems = repository.getReferenceById(id);
        return mapper.toDTO(repository.save(sellDocItems));
    }

    @Override
    public void deleteSellDocItem(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    @Override
    public List<ResSellDocItemsDTO> findAllByDocument(Integer id) {
        return mapper.toListDTO(repository.findAllByDocumentId(id));
    }
}
