package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.PriceDTO;
import org.example.marketapplication.service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
@RequiredArgsConstructor
public class PriceController {


    private final PriceService service;

    @GetMapping
    public List<PriceDTO> getAllPrices(){
        return service.getAllPrices();
    }

    @GetMapping("{id}")
    public PriceDTO getPrice(@PathVariable Integer id){

        return service.getPriceById(id);
    }

    @PostMapping
    public PriceDTO createPrice(@RequestBody PriceDTO priceDTO){

        return service.createPrice(priceDTO);
    }

    @PutMapping("{id}")
    public PriceDTO updatePrice(@PathVariable Integer id, @RequestBody PriceDTO priceDTO ){

        return service.updatePrice(id, priceDTO);

    }

    @DeleteMapping("{id}")
    public void deletePrice(@PathVariable Integer id){

        service.deletePrice(id);
    }
}
