package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ReqReturnWarehouseDocumentDTO;
import org.example.marketapplication.dto.returnWarehouseDocumentDTO.ResReturnWarehouseDocumentDTO;
import org.example.marketapplication.service.ReturnWarehouseDocumentService;
import org.example.marketapplication.service.ReturnWarehouseDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("returnWarehouseDocument")
@RequiredArgsConstructor
public class ReturnWarehouseDocumentController {


    private final ReturnWarehouseDocumentService service;

    @GetMapping
    public List<ResReturnWarehouseDocumentDTO> getAllCategories(){
        return service.getAllReturnWarehouseDocuments();
    }

    @GetMapping("{id}")
    public ResReturnWarehouseDocumentDTO getReturnWarehouseDocument(@PathVariable Integer id){

        return service.getReturnWarehouseDocumentById(id);
    }

    @PostMapping
    public ResReturnWarehouseDocumentDTO createReturnWarehouseDocument(@RequestBody ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO){

        return service.createReturnWarehouseDocument(returnWarehouseDocumentDTO);
    }

    @PutMapping("{id}")
    public ResReturnWarehouseDocumentDTO updateReturnWarehouseDocument(@PathVariable Integer id, @RequestBody ReqReturnWarehouseDocumentDTO returnWarehouseDocumentDTO ){

        return service.updateReturnWarehouseDocument(id, returnWarehouseDocumentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteReturnWarehouseDocument(@PathVariable Integer id){

        service.deleteReturnWarehouseDocument(id);
    }
}
