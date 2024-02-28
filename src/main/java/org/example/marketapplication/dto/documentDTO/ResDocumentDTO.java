package org.example.marketapplication.dto.documentDTO;

import lombok.*;
import org.example.marketapplication.dto.CompanyDTO;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResDocumentDTO {
    private Integer id;
    private Integer documentNumber;
    private CompanyDTO company;
    private Date date;

}
