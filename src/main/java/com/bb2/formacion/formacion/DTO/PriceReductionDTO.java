package com.bb2.formacion.formacion.DTO;

import com.bb2.formacion.formacion.ENTITY.PriceReduction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@ToString
@Getter
@Setter
public class PriceReductionDTO implements Serializable {
    private Long idPriceReduction;
    private int reducedPrice;
    private String end;
    private String start;
    //private Date start;
    //private Date end;
    public PriceReductionDTO(){}
}
