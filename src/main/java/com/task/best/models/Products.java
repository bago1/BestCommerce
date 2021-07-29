package com.task.best.models;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    ProductCategory productCategory;

    String productName;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "unit_price")
    Integer unitPrice;

    Integer inventory;



    @ManyToOne
    @JoinColumn(name = "merchant_id")
    Merchant merchant;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_option")
    PaymentOption paymentOption;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_option")
    DeliveryOption deliveryOption;
}
