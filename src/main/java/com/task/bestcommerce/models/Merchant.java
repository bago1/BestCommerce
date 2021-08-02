package com.task.bestcommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "merchants")
@NoArgsConstructor
@AllArgsConstructor

public class Merchant  extends BaseEntity{

    @Column(name ="merchant_type")
    String merchantType;

    String address;

    @Column(name ="phone_number" )
    String phoneNumber;

    @OneToOne(mappedBy = "merchant")
    @JsonIgnore
    private User user;

    @Column(name ="merchant_name" )
    String merchantName;

    @Column(name ="owner_name" )
    String ownerName;

    @OneToMany(mappedBy = "merchant")
    @JsonIgnore
    List<Products> products;
}