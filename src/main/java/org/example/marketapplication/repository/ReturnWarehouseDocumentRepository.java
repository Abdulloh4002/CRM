package org.example.marketapplication.repository;

import org.example.marketapplication.entity.ReturnWarehouseDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnWarehouseDocumentRepository extends JpaRepository<ReturnWarehouseDocument, Integer> {
}
