package com.task.best.api;

import com.task.best.dto.MerchantDto;
//import com.task.best.services.MerchantService;
import com.task.best.models.Products;
import com.task.best.repo.MerchantRepo;
import com.task.best.repo.UserRepo;
import com.task.best.services.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService service;


    //    @PostMapping(value = "/")
//    public ResponseEntity<MerchantDto> register(@RequestBody MerchantDto merchantDto) {
//        service.saveMerchant(merchantDto);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(merchantDto);
//    }
    @PostMapping(value = "/user")
    public ResponseEntity<MerchantDto> register(@RequestBody MerchantDto merchantDto) {
        service.saveMerchant(merchantDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(merchantDto);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Products> register(@RequestBody Products products) {
        service.saveProduct(products);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }

    @GetMapping(value = "/info")
    public String info() {
        return "this app is up";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello PXP";
    }

}
