package org.example.marketapplication.service;

import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;

import java.util.List;

public interface DocumentService {
    ResDocumentDTO getDocumentById(Integer id);
    List<ResDocumentDTO> getAllDocuments();
    ResDocumentDTO createDocument(ReqDocumentDTO documentDTO);


    ResDocumentDTO updateDocument(Integer id, ReqDocumentDTO documentDTO);


    void deleteDocument(Integer id);
}
