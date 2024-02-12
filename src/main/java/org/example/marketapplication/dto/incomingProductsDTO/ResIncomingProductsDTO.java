package org.example.marketapplication.dto.incomingProductsDTO;

import lombok.*;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResIncomingProductsDTO {
    private Integer id;
    private ResProductDTO product;
    private ResDocumentDTO document;
    private ResPriceDTO price;
    private Double amount;
}
