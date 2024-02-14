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

public class StoreDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer documentNumber;

    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
    private Set<StoreDocItems> items;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


}
