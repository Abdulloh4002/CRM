package org.example.marketapplication.service;


import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ReqReturnWarehouseDocumentDTO;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ResReturnWarehouseDocumentDTO;

import java.util.List;

public interface ReturnWarehouseDocumentService {
    ResReturnWarehouseDocumentDTO getReturnWarehouseDocumentById(Integer id);
    List<ResReturnWarehouseDocumentDTO> getAllReturnWarehouseDocuments();
    ResReturnWarehouseDocumentDTO createReturnWarehouseDocument(ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO);
    ResReturnWarehouseDocumentDTO updateReturnWarehouseDocument(Integer id, ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO);
    void deleteReturnWarehouseDocument(Integer id);
}
