package com.task.best.mappers;

import com.task.best.dto.MerchantDto;
import com.task.best.models.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    Merchant dtoToEntity(MerchantDto merchantDto);

    MerchantDto entityToDto(Merchant merchant);

}
