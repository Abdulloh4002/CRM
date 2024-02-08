package org.example.marketapplication.service;

import org.example.marketapplication.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO getPriceById(Integer id);
    List<PriceDTO> getAllPrices();
    PriceDTO createPrice(PriceDTO priceDTO);
    PriceDTO updatePrice(Integer id, PriceDTO priceDTO);
    void deletePrice(Integer id);
}
