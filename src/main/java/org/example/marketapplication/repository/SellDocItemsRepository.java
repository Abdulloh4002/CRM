package org.example.marketapplication.repository;

 import org.example.marketapplication.entity.SellDocItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import java.util.List;

@Repository
public interface SellDocItemsRepository extends JpaRepository<SellDocItems, Integer>{
    List<SellDocItems> findAllByDocumentId(Integer id);

}
