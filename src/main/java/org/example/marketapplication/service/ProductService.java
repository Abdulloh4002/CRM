package org.example.marketapplication.service;

import org.example.marketapplication.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Integer id);
    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Integer id, ProductDTO productDTO);
    void deleteProduct(Integer id);
}
