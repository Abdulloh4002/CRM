package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.DocumentDTO;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.mapper.CompanyMapper;
import org.example.marketapplication.mapper.DocumentMapper;
import org.example.marketapplication.mapper.IncomingProductsMapper;
import org.example.marketapplication.repository.DocumentRepository;
import org.example.marketapplication.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;
    private final DocumentMapper mapper;
    private final CompanyMapper companyMapper;
    private final IncomingProductsMapper incomingProductsMapper;

    @Override
    public DocumentDTO getDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<DocumentDTO> getAllDocuments() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(documentDTO)));
    }

    @Override
    public DocumentDTO updateDocument(Integer id, DocumentDTO documentDTO) {
        Document document = repository.getReferenceById(id);
        document.setDocumentNumber(documentDTO.getDocumentNumber());
        document.setDate(documentDTO.getDate());
        document.setCompany(companyMapper.toEntity(documentDTO.getCompany()));
        document.setIncomingProductsSet(incomingProductsMapper.toEntityList(documentDTO.getIncomingProductsDTOSet().stream().toList()).stream().collect(Collectors.toSet()));
        return mapper.toDTO(repository.save(document));
    }

    @Override
    public void deleteDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
