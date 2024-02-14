package org.example.marketapplication.listener;


import jakarta.persistence.PostPersist;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncomingProductsListener implements EntityListener<IncomingProducts> {
    @Autowired
    private ProductServiceImpl productService;

    @PostPersist
    @Override
    public void onInsert(IncomingProducts entity) {
        Product product = entity.getProduct();
        product.setTotalAmount(product.getTotalAmount()+ entity.getAmount());
        productService.save(product);

    }

    @Override
    public void onUpdate(IncomingProducts entity) {

    }

}
