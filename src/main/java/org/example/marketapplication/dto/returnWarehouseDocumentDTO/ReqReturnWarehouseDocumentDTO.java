package org.example.marketapplication.dto.returnWarehouseDocumentDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqReturnWarehouseDocumentDTO {
    private Integer documentNumber;
    private Date date;
}
