package org.example.marketapplication.repository;

import org.example.marketapplication.entity.SellDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocumentRepository extends JpaRepository<SellDocument, Integer> {
}
