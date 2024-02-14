package org.example.marketapplication.service;



import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;

import java.util.List;

public interface StoreDocItemsService {
    ResStoreDocItemsDTO getStoreDocItemById(Integer id);
    List<ResStoreDocItemsDTO> getAllStoreDocItems();
    ResStoreDocItemsDTO createStoreDocItem(ReqStoreDocItemsDTO storeDocItemsDTO);
    ResStoreDocItemsDTO updateStoreDocItem(Integer id, ReqStoreDocItemsDTO storeDocItemsDTO);
    void deleteStoreDocItem(Integer id);
}
