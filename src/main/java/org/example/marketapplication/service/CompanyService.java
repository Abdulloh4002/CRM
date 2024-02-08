package org.example.marketapplication.service;

import org.example.marketapplication.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO getCompanyById(Integer id);
    List<CompanyDTO> getAllCompanies();
    CompanyDTO createCompany(CompanyDTO companyDTO);
    CompanyDTO updateCompany(Integer id, CompanyDTO companyDTO);
    void deleteDocument(Integer id);
}
