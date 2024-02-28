package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;
import org.example.marketapplication.dto.sellDocument.ReqSellDocumentDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;
import org.example.marketapplication.entity.SellDocItems;
import org.example.marketapplication.entity.SellDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SellDocumentMapper extends MainMapper<ReqSellDocumentDTO, ResSellDocumentDTO, SellDocument> {

}
