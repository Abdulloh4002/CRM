package org.example.marketapplication.repository;

import org.example.marketapplication.entity.SellPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellPriceRepository extends JpaRepository<SellPrice, Integer> {
}
