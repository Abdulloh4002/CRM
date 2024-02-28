package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.returnDocumentDTO.ReqReturnDocumentDTO;
import org.example.marketapplication.dto.returnDocumentDTO.ResReturnDocumentDTO;
import org.example.marketapplication.service.ReturnDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("returnDocument")
@RequiredArgsConstructor
public class ReturnDocumentController {


    private final ReturnDocumentService service;

    @GetMapping
    public List<ResReturnDocumentDTO> getAllCategories(){
        return service.getAllReturnDocuments();
    }

    @GetMapping("{id}")
    public ResReturnDocumentDTO getReturnDocument(@PathVariable Integer id){

        return service.getReturnDocumentById(id);
    }

    @PostMapping
    public ResReturnDocumentDTO createReturnDocument(@RequestBody ReqReturnDocumentDTO returnDocumentDTO){

        return service.createReturnDocument(returnDocumentDTO);
    }

    @PutMapping("{id}")
    public ResReturnDocumentDTO updateReturnDocument(@PathVariable Integer id, @RequestBody ReqReturnDocumentDTO returnDocumentDTO ){

        return service.updateReturnDocument(id, returnDocumentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteReturnDocument(@PathVariable Integer id){

        service.deleteReturnDocument(id);
    }
}
