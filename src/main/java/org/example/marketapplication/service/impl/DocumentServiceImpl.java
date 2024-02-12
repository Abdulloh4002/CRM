package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.mapper.DocumentMapper;
import org.example.marketapplication.mapper.IncomingProductsMapper;
import org.example.marketapplication.repository.CompanyRepository;
import org.example.marketapplication.repository.DocumentRepository;
import org.example.marketapplication.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Data
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;
    private final DocumentMapper mapper;
    private final CompanyRepository companyRepository;
    private final IncomingProductsMapper incomingProductsMapper;

    @Override
    public ResDocumentDTO getDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResDocumentDTO> getAllDocuments() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResDocumentDTO createDocument(ReqDocumentDTO documentDTO) {

        Document document = mapper.toEntity(documentDTO);
//        document.setCompany(companyRepository.getReferenceById(documentDTO.getCompany()));

        return mapper
                .toDTO(repository
                        .save(document));
    }

    @Override
    public ResDocumentDTO updateDocument(Integer id, ReqDocumentDTO documentDTO) {
        Document document = repository.getReferenceById(id);
        document.setDocumentNumber(documentDTO.getDocumentNumber());
        document.setCompany(companyRepository.getReferenceById(documentDTO.getCompany()));
        return mapper.toDTO(repository.save(document));
    }

    @Override
    public void deleteDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
