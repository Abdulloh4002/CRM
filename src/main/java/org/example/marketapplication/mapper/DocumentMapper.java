package org.example.marketapplication.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.entity.Company;
import org.example.marketapplication.entity.Document;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.repository.CompanyRepository;
import org.example.marketapplication.repository.DocumentRepository;
import org.example.marketapplication.repository.IncomingProductsRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper implements MainMapper<ReqDocumentDTO, ResDocumentDTO, Document> {

    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected IncomingProductsMapper incomingProductsMapper;

    @Mapping(target = "company", expression = "java(findCompanyById(documentDTO.getCompany()))")
    @Mapping(target = "incomingProducts", expression = "java(findIncomingProducts(documentDTO.getIncomingProducts()))")
    public abstract Document toEntity(ReqDocumentDTO documentDTO);


    protected Set<IncomingProducts> findIncomingProducts(Set<ReqIncomingProductsDTO> incomingProductsDTO){
        return incomingProductsDTO.stream()
                .map(incomingProductsMapper::toEntity)
                .collect(Collectors.toSet());
    }

    protected Company findCompanyById(Integer id){
        return companyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Company not found"));
    }

}
