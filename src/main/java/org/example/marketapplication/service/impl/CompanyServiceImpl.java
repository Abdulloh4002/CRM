package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.CompanyDTO;
import org.example.marketapplication.entity.Company;
import org.example.marketapplication.mapper.CompanyMapper;
import org.example.marketapplication.repository.CompanyRepository;
import org.example.marketapplication.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(companyDTO)));
    }
    @Override
    public CompanyDTO updateCompany(Integer id, CompanyDTO companyDTO) {
        Company company = repository.getReferenceById(id);
        company.setName(companyDTO.getName());
        company.setAddress(company.getAddress());
        company.setDescription(company.getDescription());
        company.setNumber(company.getNumber());
        return mapper.toDTO(repository.save(company));
    }

    @Override
    public void deleteCompany(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
