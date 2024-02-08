package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.CategoryDTO;
import org.example.marketapplication.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
}
