package org.example.marketapplication.dto.documentDTO;

import lombok.*;
import org.example.marketapplication.dto.CompanyDTO;

import java.util.Date;

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
