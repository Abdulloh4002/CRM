package org.example.marketapplication.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private CategoryDTO categoryDTO;
    private MeasurementDTO measurementDTO;
    private Double amount;
}
