package org.example.marketapplication.dto;

import lombok.*;
import org.example.marketapplication.entity.Company;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentDTO {
    private Integer id;
    private Integer documentNumber;
    private CompanyDTO company;
    private Set<IncomingProductsDTO> incomingProductsDTOSet;
    private Date date;

}
