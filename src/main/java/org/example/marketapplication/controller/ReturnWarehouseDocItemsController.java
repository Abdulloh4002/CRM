package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.returnWarehouseDocItems.ReqReturnWarehouseDocItemsDTO;
import org.example.marketapplication.dto.returnWarehouseDocItems.ResReturnWarehouseDocItemsDTO;
import org.example.marketapplication.service.ReturnWarehouseDocItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("returnWarehouseDocItems")
@RequiredArgsConstructor
public class ReturnWarehouseDocItemsController {


    private final ReturnWarehouseDocItemsService service;

    @GetMapping
    public List<ResReturnWarehouseDocItemsDTO> getAllCategories(){
        return service.getAllReturnWarehouseDocItems();
    }

    @GetMapping("{id}")
    public ResReturnWarehouseDocItemsDTO getReturnWarehouseDocItems(@PathVariable Integer id){

        return service.getReturnWarehouseDocItemById(id);
    }

    @PostMapping
    public ResReturnWarehouseDocItemsDTO createReturnWarehouseDocItems(@RequestBody ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO){

        return service.createReturnWarehouseDocItem(returnWarehouseDocItemsDTO);
    }

    @PutMapping("{id}")
    public ResReturnWarehouseDocItemsDTO updateReturnWarehouseDocItems(@PathVariable Integer id, @RequestBody ReqReturnWarehouseDocItemsDTO returnWarehouseDocItemsDTO ){

        return service.updateReturnWarehouseDocItem(id, returnWarehouseDocItemsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteReturnWarehouseDocItems(@PathVariable Integer id){

        service.deleteReturnWarehouseDocItem(id);
    }
    @GetMapping("document/{id}")
    public List<ResReturnWarehouseDocItemsDTO> findAllByDocument(@PathVariable Integer id){
        return service.findAllByDocument(id);
    }
}
