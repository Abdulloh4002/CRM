package org.example.marketapplication.dto.documentDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqDocumentDTO {
    private Integer documentNumber;
    private Integer company;
}
