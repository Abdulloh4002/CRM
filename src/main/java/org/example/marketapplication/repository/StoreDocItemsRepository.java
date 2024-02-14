package org.example.marketapplication.repository;

import org.example.marketapplication.entity.StoreDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDocItemsRepository extends JpaRepository<StoreDocItems, Integer> {
}
