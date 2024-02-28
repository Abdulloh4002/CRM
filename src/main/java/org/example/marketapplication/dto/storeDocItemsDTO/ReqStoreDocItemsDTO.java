package org.example.marketapplication.dto.storeDocItemsDTO;


import lombok.*;
import org.example.marketapplication.entity.StoreDocument;

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
