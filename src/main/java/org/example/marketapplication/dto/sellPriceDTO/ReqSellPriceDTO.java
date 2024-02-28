package org.example.marketapplication.dto.sellPriceDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqSellPriceDTO {
    private Integer product;
    private Double price;
    private Date date;
}
