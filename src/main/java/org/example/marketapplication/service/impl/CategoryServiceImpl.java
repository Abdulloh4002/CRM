package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.CategoryDTO;
import org.example.marketapplication.entity.Category;
import org.example.marketapplication.mapper.CategoryMapper;
import org.example.marketapplication.repository.CategoryRepository;
import org.example.marketapplication.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(categoryDTO)));
    }

    @Override
    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        Category category = repository.getReferenceById(id);
        category.setName(categoryDTO.getName());
        return mapper.toDTO(repository.save(category));
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
