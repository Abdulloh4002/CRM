package org.example.marketapplication.dto.storeDocumentDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqStoreDocumentDTO {
    private Integer documentNumber;
    private Date date;
}
