package com.task.best.services;

import com.task.best.dto.MerchantDto;
import com.task.best.dto.ProductsDto;
import com.task.best.exceptions.MinimumLimitNotMatchesExeption;
import com.task.best.mappers.MerchantMapper;
import com.task.best.mappers.ProductsMapper;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final BCryptPasswordEncoder passwordEncoder;




    private final MerchantRepo repo;
    private final ProductRepo productRepo;
    private final MerchantMapper merchantMapper;
    private final ProductsMapper productsMapper;

    public void saveMerchant(MerchantDto merchantDto) {
        Merchant merchant= merchantMapper.dtoToEntity(merchantDto);
        merchant.setPassword(passwordEncoder.encode(merchantDto.getPassword()));
        repo.save(merchant);
    }

    public void saveProduct(ProductsDto productsDto) {
        Integer minimumLimit =  productsDto.getInventory();
        if(minimumLimit<5)throw new RuntimeException("Minimum inventory limit should be 5");
        Products products = productsMapper.dtoToEntity(productsDto);
        productRepo.save(products);
    }

    public List<Products> getAllProducts() {
       return productRepo.findProductsByInventoryGreaterThan(5);
    }
}
