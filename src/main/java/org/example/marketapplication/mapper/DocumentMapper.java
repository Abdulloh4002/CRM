package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.DocumentDTO;
import org.example.marketapplication.entity.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper extends EntityMapper<DocumentDTO, Document> {
}
