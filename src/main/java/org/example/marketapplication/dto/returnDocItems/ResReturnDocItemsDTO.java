package org.example.marketapplication.dto.returnDocItems;


import lombok.*;
import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.dto.returnDocumentDTO.ResReturnDocumentDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResReturnDocItemsDTO {
    private Integer id;
    private ResReturnDocumentDTO document;
    private StoreProductDTO product;
    private Double amount;
}
