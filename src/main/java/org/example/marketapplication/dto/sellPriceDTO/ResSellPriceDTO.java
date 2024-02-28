package org.example.marketapplication.dto.sellPriceDTO;

import lombok.*;
import org.example.marketapplication.dto.StoreProductDTO;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResSellPriceDTO {
    private Integer id;
    private StoreProductDTO product;
    private Double price;
    private Date date;
}
