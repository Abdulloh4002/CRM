package org.example.marketapplication.service;

import org.example.marketapplication.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {
    DocumentDTO getDocumentById(Integer id);
    List<DocumentDTO> getAllDocuments();
    DocumentDTO createDocument(DocumentDTO documentDTO);
    DocumentDTO updateDocument(Integer id, DocumentDTO documentDTO);
    void deleteDocument(Integer id);
}
