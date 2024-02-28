package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.storeDocumentDTO.ReqStoreDocumentDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;
import org.example.marketapplication.entity.StoreDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreDocumentMapper extends MainMapper<ReqStoreDocumentDTO, ResStoreDocumentDTO, StoreDocument> {


}
