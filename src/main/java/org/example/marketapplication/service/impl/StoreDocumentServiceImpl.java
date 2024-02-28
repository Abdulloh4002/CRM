package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.storeDocumentDTO.ReqStoreDocumentDTO;
import org.example.marketapplication.dto.storeDocumentDTO.ResStoreDocumentDTO;
import org.example.marketapplication.entity.*;
import org.example.marketapplication.mapper.StoreDocumentMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.StoreDocumentRepository;
import org.example.marketapplication.repository.StoreProductRepository;
import org.example.marketapplication.service.StoreDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StoreDocumentServiceImpl implements StoreDocumentService {
    private final StoreDocumentRepository repository;
    private final StoreDocumentMapper mapper;
    private final ProductRepository productRepository;
    private final StoreProductRepository storeProductRepository;

    @Override
    public ResStoreDocumentDTO getStoreDocumentById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResStoreDocumentDTO> getAllStoreDocuments() {
        return mapper.toListDTO(repository.findAll());
    }

    public ResStoreDocumentDTO createStoreDocument(ReqStoreDocumentDTO storeDocumentDTO) {
        StoreDocument storeDocument = mapper
                .toEntity(storeDocumentDTO);
//        List<StoreDocItems> list = new java.util.ArrayList<>(storeDocument.getItems().stream().toList());
//        for (int i=0;i<list.size();i++){
//
//            StoreDocItems storeDocItem = list.get(i);
//            Product product = productRepository.getReferenceById(storeDocItem.getProduct().getId());
//            if (storeDocItem.getAmount()> product.getTotalAmount()){
//                throw new EntityTypeException("The given amount is more than the actual amount","StoreDocItems");
//            }else{
//                product.setTotalAmount(product.getTotalAmount()-storeDocItem.getAmount());
//                productRepository.save(product);
//            }
//            if(storeProductRepository.existsByProductId(storeDocItem.getProduct().getId())==null){
//                StoreProduct storeProduct = StoreProduct.builder()
//                        .amount(storeDocItem.getAmount())
//                        .product(storeDocItem.getProduct())
//                .build();
//                storeProductRepository.save(storeProduct);
//            }else{
//                StoreProduct storeProduct = storeProductRepository.getReferenceById(storeProductRepository.findByProductId(storeDocItem.getProduct().getId()));
//                storeProduct.setAmount(storeProduct.getAmount()+storeDocItem.getAmount());
//                storeProductRepository.save(storeProduct);
//            }
//            storeDocItem.setDocument(storeDocument);
//            list.set(i, storeDocItem);
//        }
//        storeDocument.setItems(new HashSet<>(list));

        return mapper
                .toDTO(repository
                        .save(storeDocument));
    }

    @Override
    public ResStoreDocumentDTO updateStoreDocument(Integer id, ReqStoreDocumentDTO storeDocumentDTO) {
        StoreDocument storeDocument = repository.getReferenceById(id);
        storeDocument.setDocumentNumber(storeDocumentDTO.getDocumentNumber());
        storeDocument.setDate(storeDocumentDTO.getDate());
        return mapper.toDTO(repository.save(storeDocument));
    }

    @Override
    public void deleteStoreDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
