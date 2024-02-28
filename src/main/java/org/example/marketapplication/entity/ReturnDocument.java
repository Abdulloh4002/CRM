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

public class ReturnDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer documentNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


}
