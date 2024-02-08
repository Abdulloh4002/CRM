package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.IncomingProductsDTO;
import org.example.marketapplication.service.IncomingProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomingProducts")
@RequiredArgsConstructor
public class IncomingProductsController {


    private final IncomingProductsService service;

    @GetMapping
    public List<IncomingProductsDTO> getAllIncomingProducts(){
        return service.getAllIncomingProducts();
    }

    @GetMapping("{id}")
    public IncomingProductsDTO getIncomingProducts(@PathVariable Integer id){

        return service.getIncomingProductsById(id);
    }

    @PostMapping
    public IncomingProductsDTO createIncomingProducts(@RequestBody IncomingProductsDTO incomingProductsDTO){

        return service.createIncomingProducts(incomingProductsDTO);
    }

    @PutMapping("{id}")
    public IncomingProductsDTO updateIncomingProducts(@PathVariable Integer id, @RequestBody IncomingProductsDTO incomingProductsDTO ){

        return service.updateIncomingProducts(id, incomingProductsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteIncomingProducts(@PathVariable Integer id){

        service.deleteIncomingProducts(id);
    }
}
