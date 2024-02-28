package org.example.marketapplication.repository;

import org.example.marketapplication.entity.StoreDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreDocItemsRepository extends JpaRepository<StoreDocItems, Integer> {

    List<StoreDocItems> findAllByDocumentId(Integer id);
}
