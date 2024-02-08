package org.example.marketapplication.dto;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceDTO {
    private Integer id;
    private ProductDTO productDTO;
    private Double price;
    private Date date;
    private boolean status;
}
