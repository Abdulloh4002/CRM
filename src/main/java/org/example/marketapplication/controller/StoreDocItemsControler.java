package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.storeDocItemsDTO.ReqStoreDocItemsDTO;
import org.example.marketapplication.dto.storeDocItemsDTO.ResStoreDocItemsDTO;
import org.example.marketapplication.service.StoreDocItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("storeDocItems")
@RequiredArgsConstructor
public class StoreDocItemsControler {


    private final StoreDocItemsService service;

    @GetMapping
    public List<ResStoreDocItemsDTO> getAllCategories(){
        return service.getAllStoreDocItems();
    }

    @GetMapping("{id}")
    public ResStoreDocItemsDTO getStoreDocItems(@PathVariable Integer id){

        return service.getStoreDocItemById(id);
    }

    @PostMapping
    public ResStoreDocItemsDTO createStoreDocItems(@RequestBody ReqStoreDocItemsDTO storeDocItemsDTO){

        return service.createStoreDocItem(storeDocItemsDTO);
    }

    @PutMapping("{id}")
    public ResStoreDocItemsDTO updateStoreDocItems(@PathVariable Integer id, @RequestBody ReqStoreDocItemsDTO storeDocItemsDTO ){

        return service.updateStoreDocItem(id, storeDocItemsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteStoreDocItems(@PathVariable Integer id){

        service.deleteStoreDocItem(id);
    }
    @GetMapping("document/{id}")
    public List<ResStoreDocItemsDTO> findAllByDocument(@PathVariable Integer id){
        return service.findAllByDocument(id);
    }
}
