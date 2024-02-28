package org.example.marketapplication.dto.sellDocItemsDTO;

import lombok.*;
import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;
import org.example.marketapplication.dto.sellPriceDTO.ResSellPriceDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResSellDocItemsDTO {
    private Integer id;
    private StoreProductDTO storeProduct;
    private ResSellDocumentDTO document;
    private ResSellPriceDTO price;
    private Double amount;
}
