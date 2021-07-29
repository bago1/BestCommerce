package com.task.best.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    Integer id;

    @Column(name ="merchant_type")
    String merchantType;

    String address;

    @Column(name ="phone_number" )
    String phoneNumber;

    String email;
    String username;
    String password;


    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    List<Products> products;

}