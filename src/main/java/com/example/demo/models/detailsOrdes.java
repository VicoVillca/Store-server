package com.example.demo.models;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Table (name = "detailsOrders")
@ToString
public class detailsOrdes {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name="name")
    private String name;

    @Column (name="date")
    private Date date;

    @Column (name="shippingAddress")
    private String shippingAddress;

    @Column (name="city")
    private String city;

    @Column (name="pickup")
    private Boolean pickup;

}
