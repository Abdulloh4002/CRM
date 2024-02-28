package org.example.marketapplication.service;


import org.example.marketapplication.dto.sellPriceDTO.ReqSellPriceDTO;
import org.example.marketapplication.dto.sellPriceDTO.ResSellPriceDTO;

import java.util.List;

public interface SellPriceService {
    ResSellPriceDTO getSellPriceById(Integer id);
    List<ResSellPriceDTO> getAllSellPrices();
    ResSellPriceDTO createSellPrice(ReqSellPriceDTO priceDTO);
    ResSellPriceDTO updateSellPrice(Integer id, ReqSellPriceDTO priceDTO);
    void deleteSellPrice(Integer id);
}
