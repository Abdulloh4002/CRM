package org.example.marketapplication.service;


import org.example.marketapplication.dto.storeDocumentDTO.ReqStoreDocumentDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;

import java.util.List;

public interface StoreDocumentService {
    ResStoreDocumentDTO getStoreDocumentById(Integer id);
    List<ResStoreDocumentDTO> getAllStoreDocuments();
    ResStoreDocumentDTO createStoreDocument(ReqStoreDocumentDTO storeDocumentDTO);
    ResStoreDocumentDTO updateStoreDocument(Integer id, ReqStoreDocumentDTO storeDocumentDTO);
    void deleteStoreDocument(Integer id);
}
