package org.example.marketapplication.dto.incomingProductsDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqIncomingProductsDTO {
    private Integer product;
    private Integer price;
    private Double amount;
}
