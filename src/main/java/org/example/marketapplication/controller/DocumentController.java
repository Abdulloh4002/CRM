package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.DocumentDTO;
import org.example.marketapplication.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("document")
@RequiredArgsConstructor
public class DocumentController {


    private final DocumentService service;

    @GetMapping
    public List<DocumentDTO> getAllDocuments(){
        return service.getAllDocuments();
    }

    @GetMapping("{id}")
    public DocumentDTO getDocument(@PathVariable Integer id){

        return service.getDocumentById(id);
    }

    @PostMapping
    public DocumentDTO createDocument(@RequestBody DocumentDTO documentDTO){

        return service.createDocument(documentDTO);
    }

    @PutMapping("{id}")
    public DocumentDTO updateDocument(@PathVariable Integer id, @RequestBody DocumentDTO documentDTO ){

        return service.updateDocument(id, documentDTO);

    }

    @DeleteMapping("{id}")
    public void deleteDocument(@PathVariable Integer id){

        service.deleteDocument(id);
    }
}
