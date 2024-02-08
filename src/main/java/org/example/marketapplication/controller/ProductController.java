package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.ProductDTO;
import org.example.marketapplication.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable Integer id){

        return service.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){

        return service.createProduct(productDTO);
    }

    @PutMapping("{id}")
    public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO ){

        return service.updateProduct(id, productDTO);

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id){

        service.deleteProduct(id);
    }
}
