package com.task.bestcommerce.services;


import com.task.bestcommerce.dto.ProductsDto;
import com.task.bestcommerce.mappers.ProductsMapper;
import com.task.bestcommerce.models.Products;
import com.task.bestcommerce.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsService {

    private final ProductRepo productsRepo;
    private final ProductsMapper productsMapper;

    public Optional<ProductsDto> getOneProducts(String ProductsName) {
        log.info("Fetching Products {}", ProductsName);
        return Optional.of(productsMapper.entityToDto(productsRepo.findProductsByproductName(ProductsName)));
    }


    //todo ACCEPTANCE CRITERIA 3.1
    //todo ACCEPTANCE CRITERIA 3.2
    public ProductsDto saveProducts(ProductsDto ProductsDto) {
        log.info("Saving new Products {} to database", ProductsDto.getProductName());
        return productsMapper.entityToDto(productsRepo.save(productsMapper.dtoToEntity(ProductsDto)));
    }

    //todo ACCEPTANCE CRITERIA 3.3
    public List<ProductsDto> getAllProducts() {
        log.info("Fetching all Productss");
        List<Products> products = productsRepo.findAll();
        return productsMapper.entityListToDtoList(products.stream()
                .filter(a -> a.getInventory() > 5).collect(Collectors.toList()));
    }

//todo ACCEPTANCE CRITERIA 4.1
    public List<ProductsDto> getOnlyThisMerchantProducts() {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();


        List<Products> products = productsRepo.findAllByUsername(username);


        return productsMapper.entityListToDtoList(products);
    }


    public Optional<Products> updateProducts(ProductsDto ProductsDto) {
        Products product = productsMapper.dtoToEntity(ProductsDto);
        if (product.getId() == null || productsRepo.findById(product.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return Optional.of(productsRepo.save(product));
        }
    }

    public void deleteOneProducts(String Productsname) {
        productsRepo.delete(productsRepo.findProductsByproductName(Productsname));
    }


}

    

