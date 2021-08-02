package com.task.bestcommerce.dto;

import com.task.bestcommerce.types.DeliveryTypes;
import com.task.bestcommerce.models.Merchant;
import com.task.bestcommerce.types.PaymentTypes;
import com.task.bestcommerce.types.ProductCategoryTypes;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
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
