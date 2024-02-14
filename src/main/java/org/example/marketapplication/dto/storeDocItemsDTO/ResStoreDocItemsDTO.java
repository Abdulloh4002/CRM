package org.example.marketapplication.dto.storeDocItemsDTO;


import lombok.*;
import org.example.marketapplication.dto.productDTO.ResProductDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResStoreDocItemsDTO {
    private Integer id;
    private ResStoreDocumentDTO document;
    private ResProductDTO product;
    private Double amount;
}
