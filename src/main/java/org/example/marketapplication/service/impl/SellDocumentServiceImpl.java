package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.sellDocument.ReqSellDocumentDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;
import org.example.marketapplication.entity.*;
import org.example.marketapplication.mapper.SellDocumentMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.SellDocumentRepository;
import org.example.marketapplication.repository.StoreDocumentRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.SellDocumentService;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Data
public class SellDocumentServiceImpl implements SellDocumentService {
    private final SellDocumentRepository repository;
    private final SellDocumentMapper mapper;
    private final ProductRepository productRepository;
    private final StoreDocumentRepository storeDocument;
    private final StoreProductRepository storeProductRepository;

    @Override
    public ResSellDocumentDTO getSellDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResSellDocumentDTO> getAllSellDocuments() {
        return mapper.toListDTO(repository.findAll());
    }

    public ResSellDocumentDTO createSellDocument(ReqSellDocumentDTO sellDocumentDTO) {
        SellDocument sellDocument = mapper
                .toEntity(sellDocumentDTO);


        return mapper
                .toDTO(repository
                        .save(sellDocument));
    }

    @Override
    public ResSellDocumentDTO updateSellDocument(Integer id, ReqSellDocumentDTO sellDocumentDTO) {
        SellDocument sellDocument = repository.getReferenceById(id);
        sellDocument.setDocumentNumber(sellDocumentDTO.getDocumentNumber());
        sellDocument.setDate(sellDocumentDTO.getDate());
        return mapper.toDTO(repository.save(sellDocument));
    }

    @Override
    public void deleteSellDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
