package com.bb2.formacion.formacion.ENTITY;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter @Setter
@ToString
@AllArgsConstructor
public class PriceReduction {
    @Id
    @SequenceGenerator(
            name = "reduction_sequence",
            sequenceName = "reduction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reduction_sequence  "
    )

    private Long idPriceReduction;
    private int reducedPrice;
   // private Date start;
    private String start;
    private String end;
    private boolean active;


    public PriceReduction(){
        this.active = false;
    }

}
