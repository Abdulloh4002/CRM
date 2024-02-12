package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.incomingProductsDTO.ReqIncomingProductsDTO;
import org.example.marketapplication.dto.incomingProductsDTO.ResIncomingProductsDTO;
import org.example.marketapplication.entity.IncomingProducts;
import org.example.marketapplication.entity.Product;
import org.example.marketapplication.mapper.IncomingProductsMapper;
import org.example.marketapplication.mapper.ProductMapper;
import org.example.marketapplication.repository.IncomingProductsRepository;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.service.IncomingProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class IncomingProductsServiceImpl implements IncomingProductsService {
    private final IncomingProductsRepository repository;
    private final IncomingProductsMapper mapper;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    @Override
    public ResIncomingProductsDTO getIncomingProductsById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResIncomingProductsDTO> getAllIncomingProducts() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResIncomingProductsDTO createIncomingProducts(ReqIncomingProductsDTO incomingProductsDTO) {
        IncomingProducts incomingProducts = mapper.toEntity(incomingProductsDTO);

        Product product = productRepository.getReferenceById(incomingProductsDTO.getProduct());
        product.setTotalAmount(product.getTotalAmount() + incomingProducts.getAmount());
        productRepository.save(product);

//        incomingProducts.setProduct(product);
//        incomingProducts.setPrice(priceRepository.getReferenceById(incomingProductsDTO.getPrice()));

        return mapper
                .toDTO(repository
                        .save(incomingProducts));
    }

    @Override
    public ResIncomingProductsDTO updateIncomingProducts(Integer id, ReqIncomingProductsDTO incomingProductsDTO) {

        IncomingProducts incomingProducts = repository.getReferenceById(id);

        Product product = productRepository.getReferenceById(incomingProductsDTO.getProduct());
        product.setTotalAmount(product.getTotalAmount() + incomingProducts.getAmount());
        productRepository.save(product);

        incomingProducts.setProduct(product);
        incomingProducts.setPrice(priceRepository.getReferenceById(incomingProductsDTO.getPrice()));
        incomingProducts.setAmount(incomingProductsDTO.getAmount());

        return mapper.toDTO(repository.save(incomingProducts));
    }

    @Override
    public void deleteIncomingProducts(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
