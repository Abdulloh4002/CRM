package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ReqStoreDocumentDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;
import org.example.marketapplication.entity.StoreDocItems;
import org.example.marketapplication.entity.StoreDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class StoreDocumentMapper implements MainMapper<ReqStoreDocumentDTO, ResStoreDocumentDTO, StoreDocument> {

    @Autowired
    protected StoreDocItemsMapper storeDocItemsMapper;

    @Mapping(target = "items", expression = "java(findItems(storeDocumentDTO.getItems()))")
    public abstract StoreDocument toEntity(ReqStoreDocumentDTO storeDocumentDTO);


    protected Set<StoreDocItems> findItems(Set<ReqStoreDocItemsDTO> storeDocItemsDTO){
        return storeDocItemsDTO.stream()
                .map(storeDocItemsMapper::toEntity)
                .collect(Collectors.toSet());
    }

}
