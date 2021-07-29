package com.task.best.mappers;

import com.task.best.dto.ProductsDto;
import com.task.best.models.Products;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper {

    Products dtoToEntity(ProductsDto merchantDto);

    ProductsDto entityToDto(Products merchant);

    List<Products> dtoListToEntityList(List<ProductsDto> productsDtoList);
    List<ProductsDto> entityListToDtoList(List<Products> productsList);

}
