package org.example.marketapplication.dto.acceptDocItemsDTO;

import lombok.*;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResAcceptDocItemsDTO {
    private Integer id;
    private ResProductDTO product;
    private ResDocumentDTO document;
    private ResPriceDTO price;
    private Double amount;
}
