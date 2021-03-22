package com.bb2.formacion.formacion.ENTITY;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter @Setter
@AllArgsConstructor
public class Supplier {
    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )
    private Long idSupplier;
    private String name;
    private String country;
    @ManyToMany(mappedBy = "suppliers")

    @JsonIgnore
    private Set<Item> items = new HashSet<>() ;

    public Supplier(){}

    @Override
    public String toString() {
        return "Supplier{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", items=" + items +
                '}';
    }
}
