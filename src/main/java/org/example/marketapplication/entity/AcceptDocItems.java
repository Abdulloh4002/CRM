package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcceptDocItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Document document;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Product product;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Price price;

    private Double amount;



}
