package com.bb2.formacion.formacion.DTO;

import com.bb2.formacion.formacion.ENTITY.EnumState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class ItemDTO implements Serializable {
    private Long itemId;
    private Long code;
    private String description;
    private Double price;
    private EnumState state;
    private Set<SupplierDTO> suppliers = new HashSet<>();
    private Set<PriceReductionDTO> reductions = new HashSet<>() ;
    //private Date creationDate;
    private String creationDate;
    private String creator;
    private String reason;

    public ItemDTO(){}
    public ItemDTO(Long code, String description){
        this.code = code;
        this.description = description;
        this.state = EnumState.ACTIVE;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        this.creationDate = strDate;

    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", suppliers=" + suppliers +
                ", reductions=" + reductions +
                ", creationDate='" + creationDate + '\'' +
                ", creator='" + creator + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
