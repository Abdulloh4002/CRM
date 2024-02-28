package org.example.marketapplication.repository;

import org.example.marketapplication.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
//    Integer findByDocumentNumber(Integer number);
}
