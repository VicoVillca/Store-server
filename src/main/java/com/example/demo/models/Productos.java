package com.example.demo.models;


import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "productos")
@ToString
public class Productos {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

    @Column(name = "price")
    private double price;

    @Column (name="descripcion")
    private double dscripcion;

    @Column (name = "categoryId")
    private Integer categoryId;

    @Column(name = "stok")
    private Integer stok;



}
