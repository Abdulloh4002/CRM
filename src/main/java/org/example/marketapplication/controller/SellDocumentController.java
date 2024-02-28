package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.sellDocument.ReqSellDocumentDTO;
import org.example.marketapplication.dto.sellDocument.ResSellDocumentDTO;
import org.example.marketapplication.service.SellDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sellDocument")
@RequiredArgsConstructor
public class SellDocumentController {


    private final SellDocumentService service;

    @GetMapping
    public List<ResSellDocumentDTO> getAllCategories(){
        return service.getAllSellDocuments();
    }

    @GetMapping("{id}")
    public ResSellDocumentDTO getSellDocument(@PathVariable Integer id){

        return service.getSellDocumentById(id);
    }

    @PostMapping
    public ResSellDocumentDTO createSellDocument(@RequestBody ReqSellDocumentDTO sellDocumentDTO){

        return service.createSellDocument(sellDocumentDTO);
    }

    @PutMapping("{id}")
    public ResSellDocumentDTO updateSellDocument(@PathVariable Integer id, @RequestBody ReqSellDocumentDTO sellDocumentDTO ){

        return service.updateSellDocument(id, sellDocumentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteSellDocument(@PathVariable Integer id){

        service.deleteSellDocument(id);
    }
}
