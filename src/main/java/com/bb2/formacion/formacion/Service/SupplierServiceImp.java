package com.bb2.formacion.formacion.Service;

import com.bb2.formacion.formacion.repository.SupplierRepository;
import com.bb2.formacion.formacion.DTO.SupplierDTO;
import com.bb2.formacion.formacion.ENTITY.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SupplierServiceImp implements SupplierService{

    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SupplierDTO> getSuppliers(){
        List<SupplierDTO> listDTO = new ArrayList<>();
        for(Supplier i: supplierRepository.findAll()){
            SupplierDTO dto = modelMapper.map(i, SupplierDTO.class);
            listDTO.add(dto);
        }
        return listDTO;

    }

    public SupplierDTO findSupplierById(Long code){
        SupplierDTO dto = modelMapper.map(supplierRepository.findById(code),SupplierDTO.class );
        return dto ;
    }
}
