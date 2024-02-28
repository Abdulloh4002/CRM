package org.example.marketapplication.service;


import org.example.marketapplication.dto.StoreProductDTO;

import java.util.List;

public interface StoreProductService {
    StoreProductDTO getStoreProductById(Integer id);
    List<StoreProductDTO> getAllStoreProducts();
    StoreProductDTO createStoreProduct(StoreProductDTO storeDTO);
    StoreProductDTO updateStoreProduct(Integer id, StoreProductDTO storeDTO);
    void deleteStoreProduct(Integer id);
}
