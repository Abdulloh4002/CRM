package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDocItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ReturnDocument document;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private StoreProduct product;


    private Double amount;

}
