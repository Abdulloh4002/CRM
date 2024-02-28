package org.example.marketapplication.entity;

import jakarta.persistence.*;
import lombok.*;
//import org.example.marketapplication.listener.DocumentListener;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

//@EntityListeners(DocumentListener.class)
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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Company company;

    @OneToMany(mappedBy = "document",cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<AcceptDocItems> acceptDocItems;

    @Column(unique = true)
    private Integer documentNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
