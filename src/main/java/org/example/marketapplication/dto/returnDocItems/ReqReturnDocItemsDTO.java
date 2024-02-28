package org.example.marketapplication.dto.returnDocItems;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqReturnDocItemsDTO {
    private Integer product;
    private Integer document;
    private Double amount;
}
