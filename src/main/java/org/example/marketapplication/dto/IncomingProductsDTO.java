package org.example.marketapplication.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncomingProductsDTO {
    private Integer id;
    private ProductDTO productDTO;
    private DocumentDTO documentDTO;
    private PriceDTO priceDTO;
}
