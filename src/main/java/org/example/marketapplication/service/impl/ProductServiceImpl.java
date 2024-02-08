package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.ProductDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.mapper.CategoryMapper;
import org.example.marketapplication.mapper.MeasurementMapper;
import org.example.marketapplication.mapper.ProductMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final MeasurementMapper unitMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public ProductDTO getProductById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(productDTO)));
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product product = repository.getReferenceById(id);
        product.setName(productDTO.getName());
        product.setAmount(productDTO.getAmount());
        product.setUnit(unitMapper.toEntity(productDTO.getMeasurementDTO()));
        product.setCategory(categoryMapper.toEntity(productDTO.getCategoryDTO()));
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public void deleteDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
