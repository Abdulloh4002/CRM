package org.example.marketapplication.service.impl;

import lombok.*;
import org.example.marketapplication.dto.sellPriceDTO.ReqSellPriceDTO;
import org.example.marketapplication.dto.sellPriceDTO.ResSellPriceDTO;
import org.example.marketapplication.entity.SellPrice;
import org.example.marketapplication.mapper.SellPriceMapper;
import org.example.marketapplication.repository.ProductRepository;
import org.example.marketapplication.repository.SellPriceRepository;
import org.example.marketapplication.service.SellPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SellPriceServiceImpl implements SellPriceService {
    private final SellPriceRepository repository;
    private final SellPriceMapper mapper;
    private final ProductRepository productRepository;

    @Override
    public ResSellPriceDTO getSellPriceById(Integer id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    @Override
    public List<ResSellPriceDTO> getAllSellPrices() {
        return mapper.toListDTO(repository.findAll());
    }

    public ResSellPriceDTO createSellPrice(ReqSellPriceDTO priceDTO) {
        SellPrice sellPrice = mapper
                .toEntity(priceDTO);


        return mapper
                .toDTO(repository
                        .save(sellPrice));
    }

    @Override
    public ResSellPriceDTO updateSellPrice(Integer id, ReqSellPriceDTO priceDTO) {
        SellPrice sellPrice = repository.getReferenceById(id);
        sellPrice.setPrice(priceDTO.getPrice());
        sellPrice.setDate(priceDTO.getDate());
        sellPrice.setProduct(productRepository.getReferenceById(priceDTO.getProduct()));
        return mapper.toDTO(repository.save(sellPrice));
    }

    @Override
    public void deleteSellPrice(Integer id) {
        repository.delete(repository.getReferenceById(id));

    }
}
