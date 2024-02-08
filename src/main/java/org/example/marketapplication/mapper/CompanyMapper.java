package org.example.marketapplication.mapper;

import org.example.marketapplication.dto.CompanyDTO;
import org.example.marketapplication.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDTO, Company> {
}
