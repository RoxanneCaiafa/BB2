package com.bb2.formacion.formacion.Service;

import com.bb2.formacion.formacion.repository.PriceReductionRepository;
import com.bb2.formacion.formacion.DTO.PriceReductionDTO;
import com.bb2.formacion.formacion.ENTITY.PriceReduction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PriceReductionService {
    private PriceReductionRepository priceDAO;

    @Autowired
    private ModelMapper modelMapper;

    public List<PriceReductionDTO> getSuppliers(){
        List<PriceReductionDTO> listDTO = new ArrayList<>();
        for(PriceReduction i:priceDAO.findAll()){

            PriceReductionDTO dto = modelMapper.map(i, PriceReductionDTO.class);
            listDTO.add(dto);
        }
        return listDTO;

    }

    public PriceReductionDTO findePriceReductionById(Long code){
        PriceReductionDTO dto = modelMapper.map(priceDAO.findById(code), PriceReductionDTO.class);
        return dto;
    }

}
