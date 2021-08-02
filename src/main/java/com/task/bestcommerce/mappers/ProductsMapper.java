package com.task.bestcommerce.mappers;

import com.task.bestcommerce.dto.ProductsDto;
import com.task.bestcommerce.models.Products;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper {

    Products dtoToEntity(ProductsDto productsDto);

    ProductsDto entityToDto(Products product);

    List<Products> dtoListToEntityList(List<ProductsDto> productsDtoList);
    List<ProductsDto> entityListToDtoList(List<Products> productList);

}
