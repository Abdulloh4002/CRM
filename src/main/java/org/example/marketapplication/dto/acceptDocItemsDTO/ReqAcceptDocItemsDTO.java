package org.example.marketapplication.dto.acceptDocItemsDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqAcceptDocItemsDTO {
    private Integer product;
    private Integer document;
    private Integer price;
    private Double amount;
}
