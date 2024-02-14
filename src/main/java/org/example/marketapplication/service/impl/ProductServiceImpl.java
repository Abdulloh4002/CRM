package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.productDTO.ReqProductDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.mapper.ProductMapper;
import org.example.marketapplication.repository.CategoryRepository;
import org.example.marketapplication.repository.MeasurementRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final MeasurementRepository measurementRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ResProductDTO getProductById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResProductDTO> getAllProducts() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResProductDTO createProduct(ReqProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public ResProductDTO updateProduct(Integer id, ReqProductDTO productDTO) {
        Product product = repository.getReferenceById(id);
        product.setName(productDTO.getName());
        product.setTotalAmount(productDTO.getTotalAmount());
        product.setMeasurement(measurementRepository.getReferenceById(productDTO.getMeasurement()));
        product.setCategory(categoryRepository.getReferenceById(productDTO.getCategory()));
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    public void save(Product product){

        repository.save(product);
    }
}
