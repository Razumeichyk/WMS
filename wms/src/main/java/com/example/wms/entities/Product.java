package com.example.wms.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;
    private String unit;
    private String category;
    @ManyToMany(mappedBy = "deliveredProducts")
    private List<Supplier> suppliers;
}
