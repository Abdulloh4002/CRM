package org.example.marketapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.documentDTO.ReqDocumentDTO;
import org.example.marketapplication.dto.documentDTO.ResDocumentDTO;
import org.example.marketapplication.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("document")
@RequiredArgsConstructor
public class DocumentController {


    private final DocumentService service;

    @GetMapping
    public List<ResDocumentDTO> getAllDocuments(){
        return service.getAllDocuments();
    }

    @GetMapping("{id}")
    public ResDocumentDTO getDocument(@PathVariable Integer id){

        return service.getDocumentById(id);
    }

    @PostMapping
    public ResDocumentDTO createDocument(@RequestBody ReqDocumentDTO documentDTO){

        return service.createDocument(documentDTO);
    }

    @PutMapping("{id}")
    public ResDocumentDTO updateDocument(@PathVariable Integer id, @RequestBody ReqDocumentDTO documentDTO ){

        return service.updateDocument(id, documentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteDocument(@PathVariable Integer id){

        service.deleteDocument(id);
    }
}
