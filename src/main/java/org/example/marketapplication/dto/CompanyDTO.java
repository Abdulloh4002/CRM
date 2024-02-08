package org.example.marketapplication.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDTO {
    private Integer id;
    private String name;
    private String address;
    private String number;
    private String description;
}
