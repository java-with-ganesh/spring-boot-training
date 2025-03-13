package com.i2i.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductDetails details;


}
