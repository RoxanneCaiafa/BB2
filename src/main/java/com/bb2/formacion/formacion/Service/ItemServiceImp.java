package com.bb2.formacion.formacion.Service;


import com.bb2.formacion.formacion.DTO.ItemResponse;
import com.bb2.formacion.formacion.DTO.SupplierDTO;
import com.bb2.formacion.formacion.ENTITY.Supplier;
import com.bb2.formacion.formacion.repository.ItemRepository;
import com.bb2.formacion.formacion.DTO.ItemDTO;
import com.bb2.formacion.formacion.ENTITY.Item;
import com.bb2.formacion.formacion.repository.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    //@Resource
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
     private ModelMapper modelMapper;

//    @Transactional
    public void addNewItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getCode(), itemDTO.getDescription());

        itemRepository.save(item);
    }

    @Override
    public void addNewItemResponse(ItemResponse item) {
        Item item2 = new Item(item.getCode(), item.getDescription());

        itemRepository.save(item2);
    }

    public void deleteItem(Long id) {
       // itemRepository.findById(id);
        boolean exists = itemRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Item with id "+ id +" doesn't exists" );
        }
        itemRepository.deleteById(id);
    }


    @Transactional
    public void updateItem(Long id, ItemDTO itemDTO) throws IllegalAccessException {
        Optional<Item> pojo = itemRepository.findById(id);
        if(!pojo.isPresent()){
            throw new IllegalStateException("Item with id "+ id +" doesn't exists" );
        }
        Item i = modelMapper.map(itemDTO, Item.class);
        itemRepository.save(i);
    }


    public boolean isTheSuppAssign(Long itemId, Long supId) {
        System.out.println(itemRepository.isTheSuppAssign(itemId, supId));
       return  itemRepository.isTheSuppAssign(itemId, supId);
    }

    @Override
    public List<SupplierDTO> getSuppliers(){
        List<SupplierDTO> listDTO = new ArrayList<>();
        for(Supplier i: supplierRepository.findAll()){
            SupplierDTO dto = modelMapper.map(i, SupplierDTO.class);
            listDTO.add(dto);
        }
        return listDTO;

    }

    @Override
    public SupplierDTO findSupplierById(Long code){
        SupplierDTO dto = modelMapper.map(supplierRepository.findById(code),SupplierDTO.class );
        return dto ;
    }


    public List<ItemDTO> getItems(){
        List<ItemDTO> listDTO = new ArrayList<>();
        for(Item i: itemRepository.findAll() ){
            ItemDTO dto = modelMapper.map(i, ItemDTO.class);
            listDTO.add(dto);
        }
        return listDTO;
      }

    public ItemDTO findById(Long code){
        ItemDTO dto = null;
        Optional<Item> pojoOptional = itemRepository.findById(code);
        if(pojoOptional.isPresent()){
            Item pojo = pojoOptional.get();
             dto = modelMapper.map(pojo, ItemDTO.class);
        }else{
           throw new IllegalStateException("Item whit ID" + code + " doesn't exists");
        }

        return dto;
      }



}
