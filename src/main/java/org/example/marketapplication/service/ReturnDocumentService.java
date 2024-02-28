package org.example.marketapplication.service;


import org.example.marketapplication.dto.returnDocumentDTO.ReqReturnDocumentDTO;
import org.example.marketapplication.dto.returnDocumentDTO.ResReturnDocumentDTO;

import java.util.List;

public interface ReturnDocumentService {
    ResReturnDocumentDTO getReturnDocumentById(Integer id);
    List<ResReturnDocumentDTO> getAllReturnDocuments();
    ResReturnDocumentDTO createReturnDocument(ReqReturnDocumentDTO returnDocumentDTO);
    ResReturnDocumentDTO updateReturnDocument(Integer id, ReqReturnDocumentDTO returnDocumentDTO);
    void deleteReturnDocument(Integer id);
}
