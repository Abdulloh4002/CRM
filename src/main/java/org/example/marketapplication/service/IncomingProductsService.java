package org.example.marketapplication.service;

import org.example.marketapplication.dto.IncomingProductsDTO;

import java.util.List;

public interface IncomingProductsService {
    IncomingProductsDTO getIncomingProductsById(Integer id);
    List<IncomingProductsDTO> getAllIncomingProducts();
    IncomingProductsDTO createIncomingProducts(IncomingProductsDTO incomingProductsDTO);
    IncomingProductsDTO updateIncomingProducts(Integer id, IncomingProductsDTO incomingProductsDTO);
    void deleteIncomingProducts(Integer id);
}
