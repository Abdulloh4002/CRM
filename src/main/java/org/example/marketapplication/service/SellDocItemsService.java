package org.example.marketapplication.service;


import org.example.marketapplication.dto.sellDocItemsDTO.ReqSellDocItemsDTO;
import org.example.marketapplication.dto.sellDocItemsDTO.ResSellDocItemsDTO;

import java.util.List;

public interface SellDocItemsService {
    ResSellDocItemsDTO getSellDocItemById(Integer id);
    List<ResSellDocItemsDTO> getAllSellDocItems();
    ResSellDocItemsDTO createSellDocItem(ReqSellDocItemsDTO sellDocItemsDTO);
    ResSellDocItemsDTO updateSellDocItem(Integer id, ReqSellDocItemsDTO sellDocItemsDTO);
    void deleteSellDocItem(Integer id);
}
