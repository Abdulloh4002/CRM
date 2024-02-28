package org.example.marketapplication.service;

import org.example.marketapplication.dto.acceptDocItemsDTO.ReqAcceptDocItemsDTO;
import org.example.marketapplication.dto.acceptDocItemsDTO.ResAcceptDocItemsDTO;

import java.util.List;

public interface AcceptDocItemsService {
    ResAcceptDocItemsDTO getAcceptDocItemsById(Integer id);
    List<ResAcceptDocItemsDTO> getAllAcceptDocItems();
    ResAcceptDocItemsDTO createAcceptDocItems(ReqAcceptDocItemsDTO acceptDocItemsDTO);
    ResAcceptDocItemsDTO updateAcceptDocItems(Integer id, ReqAcceptDocItemsDTO acceptDocItemsDTO);
    List<ResAcceptDocItemsDTO> findAllByDocument(Integer id);
    void deleteAcceptDocItems(Integer id);
}
