package org.example.marketapplication.dto.storeDTO;

import lombok.*;
import org.example.marketapplication.dto.productDTO.ResProductDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResStoreProductDTO {
    private Integer id;
    private ResProductDTO product ;
    private Double amount;
}
