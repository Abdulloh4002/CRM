package org.example.marketapplication.dto.productDTO;

import lombok.*;
import org.example.marketapplication.dto.CategoryDTO;
import org.example.marketapplication.dto.MeasurementDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResProductDTO {
    private Integer id;
    private String name;
    private CategoryDTO category;
    private MeasurementDTO measurement;
    private Double totalAmount;
}
