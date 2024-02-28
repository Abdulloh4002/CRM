package org.example.marketapplication.dto.storeDocItemsDTO;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqStoreDocItemsDTO {
    private Integer product;
    private Integer document;
    private Double amount;
}
