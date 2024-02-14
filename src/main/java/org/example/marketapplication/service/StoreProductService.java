package org.example.marketapplication.service;


import org.example.marketapplication.dto.storeDTO.ReqStoreProductDTO;
import org.example.marketapplication.dto.storeDTO.ResStoreProductDTO;

import java.util.List;

public interface StoreProductService {
    ResStoreProductDTO getStoreProductById(Integer id);
    List<ResStoreProductDTO> getAllStoreProducts();
    ResStoreProductDTO createStoreProduct(ReqStoreProductDTO storeDTO);
    ResStoreProductDTO updateStoreProduct(Integer id, ReqStoreProductDTO storeDTO);
    void deleteStoreProduct(Integer id);
}
