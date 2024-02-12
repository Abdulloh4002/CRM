package org.example.marketapplication.service;

import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ResIncomingProductsDTO;

import java.util.List;

public interface IncomingProductsService {
    ResIncomingProductsDTO getIncomingProductsById(Integer id);
    List<ResIncomingProductsDTO> getAllIncomingProducts();
    ResIncomingProductsDTO createIncomingProducts(ReqIncomingProductsDTO incomingProductsDTO);
    ResIncomingProductsDTO updateIncomingProducts(Integer id, ReqIncomingProductsDTO incomingProductsDTO);
    void deleteIncomingProducts(Integer id);
}
