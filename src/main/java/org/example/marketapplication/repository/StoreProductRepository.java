package org.example.marketapplication.repository;

import org.example.marketapplication.entity.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreProductRepository extends JpaRepository<StoreProduct, Integer> {
    Integer existsByProductId(Integer productId);

}
