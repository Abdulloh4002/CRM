package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.returnDocItems.ReqReturnDocItemsDTO;
import org.example.marketapplication.dto.returnDocItems.ResReturnDocItemsDTO;
import org.example.marketapplication.service.ReturnDocItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("returnDocItems")
@RequiredArgsConstructor
public class ReturnDocItemsControler {


    private final ReturnDocItemsService service;

    @GetMapping
    public List<ResReturnDocItemsDTO> getAllCategories(){
        return service.getAllReturnDocItems();
    }

    @GetMapping("{id}")
    public ResReturnDocItemsDTO getReturnDocItems(@PathVariable Integer id){

        return service.getReturnDocItemById(id);
    }

    @PostMapping
    public ResReturnDocItemsDTO createReturnDocItems(@RequestBody ReqReturnDocItemsDTO returnDocItemsDTO){

        return service.createReturnDocItem(returnDocItemsDTO);
    }

    @PutMapping("{id}")
    public ResReturnDocItemsDTO updateReturnDocItems(@PathVariable Integer id, @RequestBody ReqReturnDocItemsDTO returnDocItemsDTO ){

        return service.updateReturnDocItem(id, returnDocItemsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteReturnDocItems(@PathVariable Integer id){

        service.deleteReturnDocItem(id);
    }
    @GetMapping("document/{id}")
    public List<ResReturnDocItemsDTO> findAllByDocument(@PathVariable Integer id){
        return service.findAllByDocument(id);
    }
}
