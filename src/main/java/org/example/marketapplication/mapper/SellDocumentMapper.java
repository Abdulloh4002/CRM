package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.sellDocument.ReqSellDocumentDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;
import org.example.marketapplication.entity.SellDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellDocumentMapper extends MainMapper<ReqSellDocumentDTO, ResSellDocumentDTO, SellDocument> {

}
