package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Document{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<IncomingProducts> incomingProductsSet;

    private Integer documentNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
