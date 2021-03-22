package com.bb2.formacion.formacion.ENTITY;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long itemId;
    private Long code;
    private String description;
    //@Transient
    private Double price;
    @Enumerated(EnumType.STRING)
    private EnumState state;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "ITEM_SUPPLIER", joinColumns = { @JoinColumn(name = "ITEM_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SUPPLIER_ID") })
    private Set<Supplier> suppliers = new HashSet<>();
    @OneToMany(targetEntity = PriceReduction.class)
    private Set<PriceReduction> reductions = new HashSet<>() ;

    private String creationDate;
    private String creator;
    private String reason;

    public Item(Long code, String description){
        this.code = code;
        this.description = description;
        this.state = EnumState.ACTIVE;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        this.creationDate = strDate;

    }

    public Item(){}

    public EnumState getState(EnumState state) {
        return this.state;
    }
/*
    public Double getPrice(){
        return (reductions.get(0)*this.price)/100;
    }
*/

    @Override
    public String toString() {
        return "Item{" +
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
