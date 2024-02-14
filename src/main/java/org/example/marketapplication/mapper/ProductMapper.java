package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.productDTO.ReqProductDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;
import org.example.marketapplication.entity.Category;
import org.example.marketapplication.entity.Measurement;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.repository.CategoryRepository;
import org.example.marketapplication.repository.MeasurementRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")

public abstract class ProductMapper implements MainMapper<ReqProductDTO, ResProductDTO, Product> {
    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected MeasurementRepository measurementRepository;
    @Mapping(target = "category",expression = "java(findCategoryById(productDTO.getCategory()))")
    @Mapping(target = "measurement",expression = "java(findMeasurementById(productDTO.getMeasurement()))")
    public abstract Product toEntity(ReqProductDTO productDTO);

    protected Category findCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    protected Measurement findMeasurementById(Integer id){
        return measurementRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Measurement not found"));
    }


}