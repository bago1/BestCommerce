package com.task.best.services;

import com.task.best.dto.MerchantDto;
import com.task.best.mappers.MerchantMapper;
import com.task.best.models.Merchant;
import com.task.best.models.Products;
import com.task.best.repo.MerchantRepo;
import com.task.best.repo.ProductRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final BCryptPasswordEncoder passwordEncoder;




    private final MerchantRepo repo;
    private final ProductRepo productRepo;
    private final MerchantMapper mapper;

    public void saveMerchant(MerchantDto merchantDto) {
        Merchant merchant= mapper.dtoToEntity(merchantDto);
        merchant.setPassword(passwordEncoder.encode(merchantDto.getPassword()));
        repo.save(merchant);
    }

    public void saveProduct(Products products) {
        productRepo.save(products);

    }
}
