package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.CompanyDTO;
import org.example.marketapplication.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {


    private final CompanyService service;

    @GetMapping
    public List<CompanyDTO> getAllCompanies(){
        return service.getAllCompanies();
    }

    @GetMapping("{id}")
    public CompanyDTO getCompany(@PathVariable Integer id){

        return service.getCompanyById(id);
    }

    @PostMapping
    public CompanyDTO createCompany(@RequestBody CompanyDTO CompanyDTO){

        return service.createCompany(CompanyDTO);
    }

    @PutMapping("{id}")
    public CompanyDTO updateCompany(@PathVariable Integer id, @RequestBody CompanyDTO CompanyDTO ){

        return service.updateCompany(id, CompanyDTO);

    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable Integer id){

        service.deleteCompany(id);
    }
}
