package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;
import org.example.marketapplication.dto.sellDocItemsDTO.ResSellDocItemsDTO;
import org.example.marketapplication.service.SellDocItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sellDocItems")
@RequiredArgsConstructor
public class SellDocItemsController {


    private final SellDocItemsService service;

    @GetMapping
    public List<ResSellDocItemsDTO> getAllCategories(){
        return service.getAllSellDocItems();
    }

    @GetMapping("{id}")
    public ResSellDocItemsDTO getSellDocItems(@PathVariable Integer id){

        return service.getSellDocItemById(id);
    }

    @PostMapping
    public ResSellDocItemsDTO createSellDocItems(@RequestBody ReqSellDocItemsDTO sellDocItemsDTO){

        return service.createSellDocItem(sellDocItemsDTO);
    }

    @PutMapping("{id}")
    public ResSellDocItemsDTO updateSellDocItems(@PathVariable Integer id, @RequestBody ReqSellDocItemsDTO sellDocItemsDTO ){

        return service.updateSellDocItem(id, sellDocItemsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteSellDocItems(@PathVariable Integer id){

        service.deleteSellDocItem(id);
    }
    @GetMapping("document/{id}")
    public List<ResSellDocItemsDTO> findAllByDocument(@PathVariable Integer id){
        return service.findAllByDocument(id);
    }
}
