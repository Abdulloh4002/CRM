package org.example.marketapplication.dto.returnWarehouseDocItems;


import lombok.*;
import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ResReturnWarehouseDocumentDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResReturnWarehouseDocItemsDTO {
    private Integer id;
    private ResReturnWarehouseDocumentDTO document;
    private StoreProductDTO storeProduct;
    private ResProductDTO product;
    private Double amount;
}
