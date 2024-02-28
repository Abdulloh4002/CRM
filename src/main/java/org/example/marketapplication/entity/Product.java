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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Category category;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Measurement measurement;

    private Double totalAmount;

    @PrePersist
    public void prePersist(){
        if (totalAmount==null){
            totalAmount=0.0;
        }
    }
}
