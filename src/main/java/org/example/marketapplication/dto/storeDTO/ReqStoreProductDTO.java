package org.example.marketapplication.dto.storeDTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqStoreProductDTO {
    private Integer product ;
    private Double amount=0.0;
}
