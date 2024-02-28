package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.storeDocumentDTO.ReqStoreDocumentDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;
import org.example.marketapplication.service.StoreDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("storeDocument")
@RequiredArgsConstructor
public class StoreDocumentController {


    private final StoreDocumentService service;

    @GetMapping
    public List<ResStoreDocumentDTO> getAllCategories(){
        return service.getAllStoreDocuments();
    }

    @GetMapping("{id}")
    public ResStoreDocumentDTO getStoreDocument(@PathVariable Integer id){

        return service.getStoreDocumentById(id);
    }

    @PostMapping
    public ResStoreDocumentDTO createStoreDocument(@RequestBody ReqStoreDocumentDTO storeDocumentDTO){

        return service.createStoreDocument(storeDocumentDTO);
    }

    @PutMapping("{id}")
    public ResStoreDocumentDTO updateStoreDocument(@PathVariable Integer id, @RequestBody ReqStoreDocumentDTO storeDocumentDTO ){

        return service.updateStoreDocument(id, storeDocumentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteStoreDocument(@PathVariable Integer id){

        service.deleteStoreDocument(id);
    }
}
