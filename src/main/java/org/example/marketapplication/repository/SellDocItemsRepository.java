package org.example.marketapplication.repository;

 import org.example.marketapplication.entity.SellDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellDocItemsRepository extends JpaRepository<SellDocItems, Integer> {
}
