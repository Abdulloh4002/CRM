package org.example.marketapplication.dto.documentDTO;

import lombok.*;
import org.example.marketapplication.dto.acceptDocItemsDTO.ReqAcceptDocItemsDTO;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqDocumentDTO {
    private Integer documentNumber;
    private Integer company;
}
