package org.example.marketapplication.dto.priceDTO;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResPriceDTO {
    private Integer id;
    private Double price;
    private Date date;
}
