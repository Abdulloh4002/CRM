package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.StoreProductDTO;
import org.example.marketapplication.service.StoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("storeProduct")
@RequiredArgsConstructor
public class StoreProductController {


    private final StoreProductService service;

    @GetMapping
    public List<StoreProductDTO> getAllCategories(){
        return service.getAllStoreProducts();
    }

    @GetMapping("{id}")
    public StoreProductDTO getStoreProduct(@PathVariable Integer id){

        return service.getStoreProductById(id);
    }

    @PostMapping
    public StoreProductDTO createStoreProduct(@RequestBody StoreProductDTO storeProductDTO){

        return service.createStoreProduct(storeProductDTO);
    }

    @PutMapping("{id}")
    public StoreProductDTO updateStoreProduct(@PathVariable Integer id, @RequestBody StoreProductDTO storeProductDTO ){

        return service.updateStoreProduct(id, storeProductDTO);

    }

    @DeleteMapping("{id}")
    public void deleteStoreProduct(@PathVariable Integer id){

        service.deleteStoreProduct(id);
    }
}
