package org.example.marketapplication.repository;

import org.example.marketapplication.entity.AcceptDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptDocItemsRepository extends JpaRepository<AcceptDocItems, Integer> {
    List<AcceptDocItems> findAllByDocumentId(Integer id);
}
