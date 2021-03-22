package com.bb2.formacion.formacion.Controller;

import com.bb2.formacion.formacion.DTO.ItemDTO;
import com.bb2.formacion.formacion.DTO.ItemResponse;
import com.bb2.formacion.formacion.DTO.SupplierDTO;
import com.bb2.formacion.formacion.ENTITY.EnumState;
import com.bb2.formacion.formacion.Service.ItemService;
import com.bb2.formacion.formacion.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path= "/item")
public class RestController {
    @Autowired
    private ItemService itemService;

    public RestController(){}
    public RestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public List<ItemDTO> getItems(){
    return itemService.getItems();
    }

    @GetMapping("/findItem")
    public ItemDTO findItemByCode(Long code){
        return itemService.findById(code);
    }
    /*

     */
    @PostMapping ("/save")
    public void addNewItem(@RequestBody ItemDTO item){
        itemService.addNewItem(item);
    }
    @PostMapping ("/saveResponse")
    public void addNewItemResponse(@RequestBody ItemResponse item){
        itemService.addNewItemResponse(item);
    }


    @DeleteMapping(path = "{itemid}")
    public void deleteItem(@PathVariable("itemId") Long id){
        itemService.deleteItem(id);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long id,@RequestBody ItemDTO item) throws IllegalAccessException {
             itemService.updateItem(id, item);
    }
/*Solo para probar que funciona*/
    @GetMapping("/isTheSuppAssign")
    public void isTheSuppAssign(Long itemId, Long supId){
        itemService.isTheSuppAssign(itemId, supId);
    }

    @GetMapping("/suppliers")
    public List<SupplierDTO> getSuppliers(){
        return itemService.getSuppliers();
    }

}
