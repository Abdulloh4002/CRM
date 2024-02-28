package org.example.marketapplication.repository;

import org.example.marketapplication.entity.ReturnWarehouseDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnWarehouseDocItemsRepository extends JpaRepository<ReturnWarehouseDocItems, Integer> {

    List<ReturnWarehouseDocItems> findAllByDocumentId(Integer id);
}
