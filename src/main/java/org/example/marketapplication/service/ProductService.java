package org.example.marketapplication.service;

import org.example.marketapplication.dto.productDTO.ReqProductDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;

import java.util.List;

public interface ProductService {
    ResProductDTO getProductById(Integer id);
    List<ResProductDTO> getAllProducts();
    ResProductDTO createProduct(ReqProductDTO productDTO);
    ResProductDTO updateProduct(Integer id, ReqProductDTO productDTO);
    void deleteProduct(Integer id);
}
