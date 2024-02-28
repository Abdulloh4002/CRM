package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.acceptDocItemsDTO.ReqAcceptDocItemsDTO;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;
import org.example.marketapplication.service.AcceptDocItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acceptDocItems")
@RequiredArgsConstructor
public class AcceptDocItemsController {


    private final AcceptDocItemsService service;

    @GetMapping
    public List<ResAcceptDocItemsDTO> getAllAcceptDocItems(){
        return service.getAllAcceptDocItems();
    }

    @GetMapping("{id}")
    public ResAcceptDocItemsDTO getAcceptDocItems(@PathVariable Integer id){

        return service.getAcceptDocItemsById(id);
    }

    @PostMapping
    public ResAcceptDocItemsDTO createAcceptDocItems(@RequestBody ReqAcceptDocItemsDTO acceptDocItemsDTO){

        return service.createAcceptDocItems(acceptDocItemsDTO);
    }

    @PutMapping("{id}")
    public ResAcceptDocItemsDTO updateAcceptDocItems(@PathVariable Integer id, @RequestBody ReqAcceptDocItemsDTO acceptDocItemsDTO ){

        return service.updateAcceptDocItems(id, acceptDocItemsDTO);

    }

    @DeleteMapping("{id}")
    public void deleteAcceptDocItems(@PathVariable Integer id){

        service.deleteAcceptDocItems(id);
    }
    @GetMapping("document/{id}")
    public List<ResAcceptDocItemsDTO> findAllByDocument(@PathVariable Integer id){
        return service.findAllByDocument(id);
    }
}
