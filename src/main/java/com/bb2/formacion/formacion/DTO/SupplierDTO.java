package com.bb2.formacion.formacion.DTO;

import com.bb2.formacion.formacion.ENTITY.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
public class SupplierDTO implements Serializable {
    private Long idSupplier;
    private String name;
    private String country;

//    private Set<Item> items = new HashSet<>() ;
    public SupplierDTO(){}
 }
