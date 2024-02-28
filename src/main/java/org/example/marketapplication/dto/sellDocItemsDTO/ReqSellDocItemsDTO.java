package org.example.marketapplication.dto.sellDocItemsDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqSellDocItemsDTO {
    private Integer storeProduct;
    private Double amount;
    private Integer price;
}
