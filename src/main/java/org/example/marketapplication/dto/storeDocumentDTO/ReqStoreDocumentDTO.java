package org.example.marketapplication.dto.storeDocumentDTO;

import lombok.*;
import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqStoreDocumentDTO {
    private Integer documentNumber;
    private Set<ReqStoreDocItemsDTO> items;
    private Date date;
}
