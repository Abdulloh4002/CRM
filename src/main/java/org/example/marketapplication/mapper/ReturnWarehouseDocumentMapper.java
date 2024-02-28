package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ReqReturnWarehouseDocumentDTO;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ResReturnWarehouseDocumentDTO;
import org.example.marketapplication.entity.ReturnWarehouseDocument;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReturnWarehouseDocumentMapper extends MainMapper<ReqReturnWarehouseDocumentDTO, ResReturnWarehouseDocumentDTO, ReturnWarehouseDocument> {


}
