package org.example.marketapplication.dto.productDTO;

import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqProductDTO {
    private String name;
    private Integer category;
    private Integer measurement;
    private Double totalAmount;
}
