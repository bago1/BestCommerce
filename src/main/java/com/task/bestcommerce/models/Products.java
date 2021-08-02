package com.task.bestcommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.bestcommerce.types.DeliveryTypes;
import com.task.bestcommerce.types.PaymentTypes;
import com.task.bestcommerce.types.ProductCategoryTypes;
import lombok.Data;

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
    ProductCategoryTypes productCategory;

    String productName;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "unit_price")
    Integer unitPrice;

    Integer inventory;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    @JsonIgnore
    Merchant merchant;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_option")
    PaymentTypes paymentOption;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_option")
    DeliveryTypes deliveryOption;
}
