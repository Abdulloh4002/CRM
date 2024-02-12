package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.entity.Company;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.repository.CompanyRepository;
import org.example.marketapplication.repository.DocumentRepository;
import org.example.marketapplication.repository.IncomingProductsRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper implements MainMapper<ReqDocumentDTO, ResDocumentDTO, Document> {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private IncomingProductsRepository incomingProductsRepository;

    @Mapping(target = "company", expression = "java(findCompanyById(documentDTO.getCompany()))")
    public abstract Document toEntity(ReqDocumentDTO documentDTO);

    protected Company findCompanyById(Integer id){
        return companyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Company not found"));
    }

}
