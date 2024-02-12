package org.example.marketapplication.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Measurement measurement;

    private Double totalAmount;

    @PrePersist
    public void prePersist(){
        if (totalAmount==null){
            totalAmount=0.0;
        }
    }
}
