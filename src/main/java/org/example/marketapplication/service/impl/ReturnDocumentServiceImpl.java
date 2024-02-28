package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.returnDocumentDTO.ReqReturnDocumentDTO;
import org.example.marketapplication.dto.returnDocumentDTO.ResReturnDocumentDTO;
import org.example.marketapplication.entity.*;
import org.example.marketapplication.mapper.ReturnDocumentMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.ReturnDocumentRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.ReturnDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReturnDocumentServiceImpl implements ReturnDocumentService {
    private final ReturnDocumentRepository repository;
    private final ReturnDocumentMapper mapper;
    private final ProductRepository productRepository;
    private final StoreProductRepository storeProductRepository;

    @Override
    public ResReturnDocumentDTO getReturnDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResReturnDocumentDTO> getAllReturnDocuments() {
        return mapper.toListDTO(repository.findAll());
    }

    public ResReturnDocumentDTO createReturnDocument(ReqReturnDocumentDTO returnDocumentDTO) {
        ReturnDocument returnDocument = mapper
                .toEntity(returnDocumentDTO);

        return mapper
                .toDTO(repository
                        .save(returnDocument));
    }

    @Override
    public ResReturnDocumentDTO updateReturnDocument(Integer id, ReqReturnDocumentDTO returnDocumentDTO) {
        ReturnDocument returnDocument = repository.getReferenceById(id);
        returnDocument.setDocumentNumber(returnDocumentDTO.getDocumentNumber());
        returnDocument.setDate(returnDocumentDTO.getDate());
        return mapper.toDTO(repository.save(returnDocument));
    }

    @Override
    public void deleteReturnDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
