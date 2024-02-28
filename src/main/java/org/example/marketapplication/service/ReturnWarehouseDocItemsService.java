package org.example.marketapplication.service;




import org.example.marketapplication.dto.returnWarehouseDocItems.ReqReturnWarehouseDocItemsDTO;
import org.example.marketapplication.dto.returnWarehouseDocItems.ResReturnWarehouseDocItemsDTO;

import java.util.List;

public interface ReturnWarehouseDocItemsService {
    ResReturnWarehouseDocItemsDTO getReturnWarehouseDocItemById(Integer id);
    List<ResReturnWarehouseDocItemsDTO> getAllReturnWarehouseDocItems();
    ResReturnWarehouseDocItemsDTO createReturnWarehouseDocItem(ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO);
    ResReturnWarehouseDocItemsDTO updateReturnWarehouseDocItem(Integer id, ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO);
    void deleteReturnWarehouseDocItem(Integer id);
    List<ResReturnWarehouseDocItemsDTO> findAllByDocument(Integer id);
}
