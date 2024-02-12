package org.example.marketapplication.service;

import org.example.marketapplication.dto.priceDTO.ReqPriceDTO;
import org.example.marketapplication.dto.priceDTO.ResPriceDTO;

import java.util.List;

public interface PriceService {
    ResPriceDTO getPriceById(Integer id);
    List<ResPriceDTO> getAllPrices();
    ResPriceDTO createPrice(ReqPriceDTO priceDTO);
    ResPriceDTO updatePrice(Integer id, ReqPriceDTO priceDTO);
    void deletePrice(Integer id);
}
