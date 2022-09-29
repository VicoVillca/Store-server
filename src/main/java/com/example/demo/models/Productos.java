package com.example.demo.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "productos")
@ToString
public class Productos {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column (name = "id")
    private Integer id;

    @Getter @Setter
    @Column (name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "price")
    private double price;

    @Getter @Setter
    @Column (name="description")
    private String description;

    @Getter @Setter
    @Column (name = "categoryId")
    private Integer categoryId;

    @Getter @Setter
    @Column(name = "stock")
    private Integer stock;



}
