package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.priceDTO.ReqPriceDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;
import org.example.marketapplication.service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
@RequiredArgsConstructor
public class PriceController {


    private final PriceService service;

    @GetMapping
    public List<ResPriceDTO> getAllPrices(){
        return service.getAllPrices();
    }

    @GetMapping("{id}")
    public ResPriceDTO getPrice(@PathVariable Integer id){

        return service.getPriceById(id);
    }

    @PostMapping
    public ResPriceDTO createPrice(@RequestBody ReqPriceDTO priceDTO){

        return service.createPrice(priceDTO);
    }

    @PutMapping("{id}")
    public ResPriceDTO updatePrice(@PathVariable Integer id, @RequestBody ReqPriceDTO priceDTO ){

        return service.updatePrice(id, priceDTO);

    }

    @DeleteMapping("{id}")
    public void deletePrice(@PathVariable Integer id){

        service.deletePrice(id);
    }
}
