package com.task.best.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column (name = "product_category")
    ProductCategory productCategory;

    String productName;

    @Column (name = "product_description")
    String productDescription;

    @Column (name = "unit_price")
    Integer unitPrice;

    Integer inventory;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    Merchant merchants;


}
