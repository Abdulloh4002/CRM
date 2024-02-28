package org.example.marketapplication.dto.sellDocument;

import lombok.*;
import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqSellDocumentDTO {
    private Integer documentNumber;
    private Date date;
}
