package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.acceptDocItemsDTO.ReqAcceptDocItemsDTO;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;
import org.example.marketapplication.entity.AcceptDocItems;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.mapper.AcceptDocItemsMapper;
import org.example.marketapplication.repository.AcceptDocItemsRepository;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.service.AcceptDocItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AcceptDocItemsServiceImpl implements AcceptDocItemsService {
    private final AcceptDocItemsRepository repository;
    private final AcceptDocItemsMapper mapper;
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;

    @Override
    public ResAcceptDocItemsDTO getAcceptDocItemsById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResAcceptDocItemsDTO> getAllAcceptDocItems() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResAcceptDocItemsDTO createAcceptDocItems(ReqAcceptDocItemsDTO acceptDocItemsDTO) {

        Product product = productRepository.getReferenceById(acceptDocItemsDTO.getProduct());
        product.setTotalAmount(product.getTotalAmount()+ acceptDocItemsDTO.getAmount());
        productRepository.save(product);

        AcceptDocItems acceptDocItems = mapper.toEntity(acceptDocItemsDTO);

        return mapper
                .toDTO(repository
                        .save(acceptDocItems));
    }

    @Override
    public ResAcceptDocItemsDTO updateAcceptDocItems(Integer id, ReqAcceptDocItemsDTO acceptDocItemsDTO) {

        AcceptDocItems acceptDocItems = repository.getReferenceById(id);


        acceptDocItems.setProduct(productRepository.getReferenceById(acceptDocItemsDTO.getProduct()));
        acceptDocItems.setPrice(priceRepository.getReferenceById(acceptDocItemsDTO.getPrice()));
        acceptDocItems.setAmount(acceptDocItemsDTO.getAmount());

        return mapper.toDTO(repository.save(acceptDocItems));
    }

    @Override
    public void deleteAcceptDocItems(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }

    @Override
    public List<ResAcceptDocItemsDTO> findAllByDocument(Integer id){
        return mapper.toListDTO(repository.findAllByDocumentId(id));
    }


}
