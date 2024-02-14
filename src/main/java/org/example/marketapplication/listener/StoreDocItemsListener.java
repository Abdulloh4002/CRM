package org.example.marketapplication.listener;

import jakarta.persistence.PrePersist;
import org.example.marketapplication.dto.storeDTO.ReqStoreProductDTO;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.entity.StoreDocItems;
import org.example.marketapplication.entity.StoreProduct;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.impl.ProductServiceImpl;
import org.example.marketapplication.service.impl.StoreProductServiceImpl;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreDocItemsListener implements EntityListener<StoreDocItems> {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private StoreProductServiceImpl storeProductService;

    @Autowired
    private StoreProductRepository storeProductRepository;


    @PrePersist
    @Override
    public void onInsert(StoreDocItems entity) {


        Product product = entity.getProduct();
        if(product.getTotalAmount()+entity.getAmount()< entity.getAmount()){
            throw new EntityTypeException("The given amount is more than the actual amount","Store Product");
        }
        product.setTotalAmount(product.getTotalAmount()-entity.getAmount());
        productService.save(product);
        Integer id = storeProductRepository.existsByProductId(entity.getProduct().getId());
        if (id==null){

            storeProductService.createStoreProduct(
                    ReqStoreProductDTO.builder()
                            .amount(entity.getAmount())
                            .product(entity.getProduct().getId())
                            .build()
            );
        }else{

            StoreProduct storeProduct = storeProductRepository.getReferenceById(id);
            storeProduct.setAmount(storeProduct.getAmount()+ entity.getAmount());
            storeProductRepository.save(storeProduct);

        }


    }

    @Override
    public void onUpdate(StoreDocItems entity) {

    }
}
