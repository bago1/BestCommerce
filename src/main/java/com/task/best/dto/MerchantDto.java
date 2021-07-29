package com.task.best.dto;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Data
public class MerchantDto {

    String merchantType;
    String merchantName;
    String ownerName;
    String address;
    String phoneNumber;
    String email;
    String username;
    String password;


}
