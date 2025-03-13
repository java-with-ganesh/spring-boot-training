package com.i2i.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String manufacturer;

    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
}
