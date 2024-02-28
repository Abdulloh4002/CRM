package org.example.marketapplication.dto.returnDocumentDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqReturnDocumentDTO {
    private Integer documentNumber;
    private Date date;
}
