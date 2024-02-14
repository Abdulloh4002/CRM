package org.example.marketapplication.dto.storeDocumentDTO;

import lombok.*;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResStoreDocumentDTO {
    private Integer id;
    private Integer documentNumber;
    private Set<ResStoreDocItemsDTO> items;
    private Date date;

}
