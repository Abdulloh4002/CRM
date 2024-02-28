package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.returnDocumentDTO.ReqReturnDocumentDTO;
import org.example.marketapplication.dto.returnDocumentDTO.ResReturnDocumentDTO;
import org.example.marketapplication.entity.ReturnDocument;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReturnDocumentMapper extends MainMapper<ReqReturnDocumentDTO, ResReturnDocumentDTO, ReturnDocument> {


}
