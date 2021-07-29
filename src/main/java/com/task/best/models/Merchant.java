package com.task.best.models;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    Integer id;

    @Column(name ="merchant_type")
    String merchantType;

    String address;

    @Column(name ="phone_number" )
    String phoneNumber;

    String email;
    String username;
    String password;

    @OneToMany(mappedBy = "merchants", cascade = CascadeType.ALL)
    List<Products> products;





}
