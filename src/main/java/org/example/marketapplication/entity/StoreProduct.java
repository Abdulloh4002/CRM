package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoreProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    private Double amount;

    @PrePersist
    public void prePersist(){
        if(amount==null)
            amount=0.0;
    }
}
