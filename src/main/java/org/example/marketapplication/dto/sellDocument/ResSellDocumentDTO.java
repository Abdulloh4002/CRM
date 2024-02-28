package org.example.marketapplication.dto.sellDocument;

import lombok.*;
import org.example.marketapplication.dto.sellDocItemsDTO.ResSellDocItemsDTO;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResSellDocumentDTO {
    private Integer id;
    private Integer documentNumber;
    private Date date;

}
