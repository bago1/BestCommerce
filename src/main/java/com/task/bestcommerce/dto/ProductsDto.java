package com.task.bestcommerce.dto;

import com.task.bestcommerce.types.DeliveryTypes;
import com.task.bestcommerce.models.Merchant;
import com.task.bestcommerce.types.PaymentTypes;
import com.task.bestcommerce.types.ProductCategoryTypes;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsDto {
    ProductCategoryTypes productCategory;
    String productName;
    String productDescription;
    BigDecimal unitPrice;
    Integer inventory;
    Merchant merchant;
    PaymentTypes paymentOption;
    DeliveryTypes deliveryOption;
}
