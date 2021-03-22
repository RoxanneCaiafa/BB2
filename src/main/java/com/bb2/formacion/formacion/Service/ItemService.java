package com.bb2.formacion.formacion.Service;

import com.bb2.formacion.formacion.DTO.ItemDTO;
import com.bb2.formacion.formacion.DTO.ItemResponse;
import com.bb2.formacion.formacion.DTO.SupplierDTO;

import java.util.List;

public interface ItemService {
     List<ItemDTO> getItems();

     ItemDTO findById(Long code);

   void addNewItem(ItemDTO item);

    void addNewItemResponse(ItemResponse item);

    void deleteItem(Long id);

    void updateItem(Long id, ItemDTO item) throws IllegalAccessException;


    boolean isTheSuppAssign(Long itemId, Long supId);

    List<SupplierDTO> getSuppliers();
    SupplierDTO findSupplierById(Long code);
}
