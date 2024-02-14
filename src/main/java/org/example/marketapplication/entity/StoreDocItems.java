package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDocItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private StoreDocument document;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;


    private Double amount;



}
