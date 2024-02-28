package org.example.marketapplication.repository;

import org.example.marketapplication.entity.ReturnDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnDocItemsRepository extends JpaRepository<ReturnDocItems, Integer> {

    List<ReturnDocItems> findAllByDocumentId(Integer id);
}
