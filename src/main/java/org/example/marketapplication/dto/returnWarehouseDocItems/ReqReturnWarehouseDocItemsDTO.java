package org.example.marketapplication.dto.returnWarehouseDocItems;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqReturnWarehouseDocItemsDTO {
    private Integer product;
    private Integer storeProduct;
    private Integer document;
    private Double amount;
}
