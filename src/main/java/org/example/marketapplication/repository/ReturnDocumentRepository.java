package org.example.marketapplication.repository;

import org.example.marketapplication.entity.ReturnDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnDocumentRepository extends JpaRepository<ReturnDocument, Integer> {
}
