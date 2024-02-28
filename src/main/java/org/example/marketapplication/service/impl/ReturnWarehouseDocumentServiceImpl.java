package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ReqReturnWarehouseDocumentDTO;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ResReturnWarehouseDocumentDTO;
import org.example.marketapplication.entity.*;
import org.example.marketapplication.mapper.ReturnWarehouseDocumentMapper;
import org.example.marketapplication.repository.ReturnWarehouseDocumentRepository;
import org.example.marketapplication.service.ReturnWarehouseDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReturnWarehouseDocumentServiceImpl implements ReturnWarehouseDocumentService {
    private final ReturnWarehouseDocumentRepository repository;
    private final ReturnWarehouseDocumentMapper mapper;

    @Override
    public ResReturnWarehouseDocumentDTO getReturnWarehouseDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResReturnWarehouseDocumentDTO> getAllReturnWarehouseDocuments() {
        return mapper.toListDTO(repository.findAll());
    }

    public ResReturnWarehouseDocumentDTO createReturnWarehouseDocument(ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO) {
        ReturnWarehouseDocument returnWarehouseDocument = mapper
                .toEntity(returnWarehouseDocumentDTO);

        return mapper
                .toDTO(repository
                        .save(returnWarehouseDocument));
    }

    @Override
    public ResReturnWarehouseDocumentDTO updateReturnWarehouseDocument(Integer id, ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO) {
        ReturnWarehouseDocument returnWarehouseDocument = repository.getReferenceById(id);
        returnWarehouseDocument.setDocumentNumber(returnWarehouseDocumentDTO.getDocumentNumber());
        returnWarehouseDocument.setDate(returnWarehouseDocumentDTO.getDate());
        return mapper.toDTO(repository.save(returnWarehouseDocument));
    }

    @Override
    public void deleteReturnWarehouseDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
