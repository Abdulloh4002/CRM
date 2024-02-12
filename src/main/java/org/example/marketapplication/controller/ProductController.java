package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.productDTO.ReqProductDTO;
import org.example.marketapplication.dto.productDTO.ResProductDTO;
import org.example.marketapplication.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping
    public List<ResProductDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public ResProductDTO getProduct(@PathVariable Integer id){

        return service.getProductById(id);
    }

    @PostMapping
    public ResProductDTO createProduct(@RequestBody ReqProductDTO productDTO){

        return service.createProduct(productDTO);
    }

    @PutMapping("{id}")
    public ResProductDTO updateProduct(@PathVariable Integer id, @RequestBody ReqProductDTO productDTO ){

        return service.updateProduct(id, productDTO);

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id){

        service.deleteProduct(id);
    }
}
