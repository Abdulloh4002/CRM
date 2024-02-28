package org.example.marketapplication.dto.returnWarehouseDocumentDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResReturnWarehouseDocumentDTO {
    private Integer id;
    private Integer documentNumber;
    private Date date;

}
