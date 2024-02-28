package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.sellPriceDTO.ReqSellPriceDTO;
import org.example.marketapplication.dto.sellPriceDTO.ResSellPriceDTO;
import org.example.marketapplication.service.SellPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sellPrice")
@RequiredArgsConstructor
public class SellPriceController {


    private final SellPriceService service;

    @GetMapping
    public List<ResSellPriceDTO> getAllSellPrice(){
        return service.getAllSellPrices();
    }

    @GetMapping("{id}")
    public ResSellPriceDTO getSellPrice(@PathVariable Integer id){

        return service.getSellPriceById(id);
    }

    @PostMapping
    public ResSellPriceDTO createSellPrice(@RequestBody ReqSellPriceDTO sellPriceDTO){

        return service.createSellPrice(sellPriceDTO);
    }

    @PutMapping("{id}")
    public ResSellPriceDTO updateSellPrice(@PathVariable Integer id, @RequestBody ReqSellPriceDTO sellPriceDTO ){

        return service.updateSellPrice(id, sellPriceDTO);

    }

    @DeleteMapping("{id}")
    public void deleteSellPrice(@PathVariable Integer id){

        service.deleteSellPrice(id);
    }
}
