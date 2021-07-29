package com.task.best.dto;

import com.task.best.models.DeliveryOption;
import com.task.best.models.Merchant;
import com.task.best.models.PaymentOption;
import com.task.best.models.ProductCategory;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProductsDto {
    ProductCategory productCategory;
    String productName;
    String productDescription;
    Integer unitPrice;
    Integer inventory;
    Merchant merchant;
    PaymentOption paymentOption;
    DeliveryOption deliveryOption;
}
