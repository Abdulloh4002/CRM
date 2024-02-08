package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.IncomingProductsDTO;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.mapper.DocumentMapper;
import org.example.marketapplication.mapper.IncomingProductsMapper;
import org.example.marketapplication.mapper.PriceMapper;
import org.example.marketapplication.mapper.ProductMapper;
import org.example.marketapplication.repository.IncomingProductsRepository;
import org.example.marketapplication.service.IncomingProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class IncomingProductsServiceImpl implements IncomingProductsService {
    private final IncomingProductsRepository repository;
    private final IncomingProductsMapper mapper;
    private final PriceMapper priceMapper;
    private final DocumentMapper documentMapper;
    private final ProductMapper productMapper;

    @Override
    public IncomingProductsDTO getIncomingProductsById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<IncomingProductsDTO> getAllIncomingProducts() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public IncomingProductsDTO createIncomingProducts(IncomingProductsDTO incomingProductsDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(incomingProductsDTO)));
    }

    @Override
    public IncomingProductsDTO updateIncomingProducts(Integer id, IncomingProductsDTO incomingProductsDTO) {

        IncomingProducts incomingProducts = repository.getReferenceById(id);
        incomingProducts.setProduct(productMapper.toEntity(incomingProductsDTO.getProductDTO()));
        incomingProducts.setPrice(priceMapper.toEntity(incomingProductsDTO.getPriceDTO()));
        incomingProducts.setDocument(documentMapper.toEntity(incomingProductsDTO.getDocumentDTO()));

        return mapper.toDTO(repository.save(incomingProducts));
    }

    @Override
    public void deleteIncomingProducts(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
