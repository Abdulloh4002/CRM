package org.example.marketapplication.dto.sellDocument;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqSellDocumentDTO {
    private Integer documentNumber;
    private Date date;
}
