package org.example.marketapplication.service;



import org.example.marketapplication.dto.sellDocument.ReqSellDocumentDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;

import java.util.List;

public interface SellDocumentService {
    ResSellDocumentDTO getSellDocumentById(Integer id);
    List<ResSellDocumentDTO> getAllSellDocuments();
    ResSellDocumentDTO createSellDocument(ReqSellDocumentDTO sellDocumentDTO);
    ResSellDocumentDTO updateSellDocument(Integer id, ReqSellDocumentDTO sellDocumentDTO);
    void deleteSellDocument(Integer id);
}
