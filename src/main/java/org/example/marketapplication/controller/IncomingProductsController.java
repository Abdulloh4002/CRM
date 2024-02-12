package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ResIncomingProductsDTO;
import org.example.marketapplication.service.IncomingProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomingProducts")
@RequiredArgsConstructor
public class IncomingProductsController {


    private final IncomingProductsService service;

    @GetMapping
    public List<ResIncomingProductsDTO> getAllIncomingProducts(){
        return service.getAllIncomingProducts();
    }

    @GetMapping("{id}")
    public ResIncomingProductsDTO getIncomingProducts(@PathVariable Integer id){

        return service.getIncomingProductsById(id);
    }

    @PostMapping
    public ResIncomingProductsDTO createIncomingProducts(@RequestBody ReqIncomingProductsDTO incomingProductsDTO){

        return service.createIncomingProducts(incomingProductsDTO);
    }

    @PutMapping("{id}")
    public ResIncomingProductsDTO updateIncomingProducts(@PathVariable Integer id, @RequestBody ReqIncomingProductsDTO incomingProductsDTO ){

        return service.updateIncomingProducts(id, incomingProductsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteIncomingProducts(@PathVariable Integer id){

        service.deleteIncomingProducts(id);
    }
}
