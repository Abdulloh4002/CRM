package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.priceDTO.ReqPriceDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.mapper.PriceMapper;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PriceServiceImpl implements PriceService {
    private final PriceRepository repository;
    private final PriceMapper mapper;
    private final ProductRepository productRepository;

    @Override
    public ResPriceDTO getPriceById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResPriceDTO> getAllPrices() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public ResPriceDTO createPrice(ReqPriceDTO priceDTO) {

        Price price = mapper.toEntity(priceDTO);
//        price.setProduct(productRepository.getReferenceById(priceDTO.getProduct()));
        return mapper
                .toDTO(repository
                        .save(price));
    }

    @Override
    public ResPriceDTO updatePrice(Integer id, ReqPriceDTO priceDTO) {
        Price price = repository.getReferenceById(id);
        price.setPrice(priceDTO.getPrice());
        price.setProduct(productRepository.getReferenceById(priceDTO.getProduct()));
        price.setDate(priceDTO.getDate());
        return mapper.toDTO(repository.save(price));
    }

    @Override
    public void deletePrice(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
