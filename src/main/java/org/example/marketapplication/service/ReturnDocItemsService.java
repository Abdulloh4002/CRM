package org.example.marketapplication.service;




import org.example.marketapplication.dto.returnDocItems.ReqReturnDocItemsDTO;
import org.example.marketapplication.dto.returnDocItems.ResReturnDocItemsDTO;

import java.util.List;

public interface ReturnDocItemsService {
    ResReturnDocItemsDTO getReturnDocItemById(Integer id);
    List<ResReturnDocItemsDTO> getAllReturnDocItems();
    ResReturnDocItemsDTO createReturnDocItem(ReqReturnDocItemsDTO returnDocItemsDTO);
    ResReturnDocItemsDTO updateReturnDocItem(Integer id, ReqReturnDocItemsDTO returnDocItemsDTO);
    void deleteReturnDocItem(Integer id);
    List<ResReturnDocItemsDTO> findAllByDocument(Integer id);
}
