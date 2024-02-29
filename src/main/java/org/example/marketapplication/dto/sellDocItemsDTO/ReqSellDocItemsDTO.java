package org.example.marketapplication.dto.sellDocItemsDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqSellDocItemsDTO {
    private Integer product;
    private Integer document;
    private Double amount;
    private Integer price;
}
