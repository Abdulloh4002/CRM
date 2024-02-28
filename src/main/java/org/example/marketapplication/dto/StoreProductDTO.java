package org.example.marketapplication.dto;

import lombok.*;
import org.example.marketapplication.dto.productDTO.ResProductDTO;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreProductDTO {
    private Integer id;
    private ResProductDTO product ;
    private Double amount;
}
