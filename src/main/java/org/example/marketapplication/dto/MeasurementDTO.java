package org.example.marketapplication.dto;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MeasurementDTO {
    private Integer id;
    private String name;
}
