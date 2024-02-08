package org.example.marketapplication.repository;

import org.example.marketapplication.entity.IncomingProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingProductsRepository extends JpaRepository<IncomingProducts, Integer> {
}
