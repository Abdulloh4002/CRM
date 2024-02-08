package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.PriceDTO;
import org.example.marketapplication.entity.Price;
import org.example.marketapplication.mapper.PriceMapper;
import org.example.marketapplication.mapper.ProductMapper;
import org.example.marketapplication.repository.PriceRepository;
import org.example.marketapplication.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PriceServiceImpl implements PriceService {
    private final PriceRepository repository;
    private final PriceMapper mapper;
    private final ProductMapper productMapper;

    @Override
    public PriceDTO getPriceById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<PriceDTO> getAllPrices() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public PriceDTO createPrice(PriceDTO priceDTO) {
        return mapper
                .toDTO(repository
                        .save(mapper
                                .toEntity(priceDTO)));
    }

    @Override
    public PriceDTO updatePrice(Integer id, PriceDTO priceDTO) {
        Price price = repository.getReferenceById(id);
        price.setPrice(priceDTO.getPrice());
        price.setProduct(productMapper.toEntity(priceDTO.getProductDTO()));
        price.setStatus(priceDTO.isStatus());
        price.setDate(priceDTO.getDate());
        return mapper.toDTO(repository.save(price));
    }

    @Override
    public void deleteDocument(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
