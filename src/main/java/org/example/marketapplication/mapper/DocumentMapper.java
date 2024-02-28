package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;
import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.entity.AcceptDocItems;
import org.example.marketapplication.entity.Company;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.repository.CompanyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class DocumentMapper implements MainMapper<ReqDocumentDTO, ResDocumentDTO, Document> {

    @Autowired
    protected CompanyRepository companyRepository;
//    @Autowired
//    protected AcceptDocItemsMapper acceptDocItemsMapper;

    @Mapping(target = "company", expression = "java(findCompanyById(documentDTO.getCompany()))")
//    @Mapping(target = "acceptDocItems", expression = "java(findAcceptDocItems(document.getAcceptDocItems()))")
    public abstract Document toEntity(ReqDocumentDTO documentDTO);


//    protected Set<ResAcceptDocItemsDTO> findAcceptDocItems(Set<AcceptDocItems> acceptDocItems){
//        return acceptDocItemsMapper.toListDTO(acceptDocItems.stream().toList()).stream().collect(Collectors.toSet());
//    }

    protected Company findCompanyById(Integer id){
        return companyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Company not found"));
    }

}
//package org.example.marketapplication.mapper;
//
//import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
//import org.example.marketapplication.entity.Company;
//import org.mapstruct.Mapper;
//
//@Mapper(componentModel = "spring")
//public interface DocumentMapper extends EntityMapper<ResDocumentDTO, Company> {
//}
