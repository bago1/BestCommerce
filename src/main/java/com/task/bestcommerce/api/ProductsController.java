package com.task.bestcommerce.api;

import com.task.bestcommerce.dto.ProductsDto;
import com.task.bestcommerce.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;


    @GetMapping("/products")
    public ResponseEntity<List<ProductsDto>> getAllProducts() {
        return ResponseEntity
                .ok()
                .body(productsService.getAllProducts());
    }

//    @GetMapping("/merchantproducts")
//    public ResponseEntity<List<ProductsDto>> getOnlyThisMerchantProducts() {
//        return ResponseEntity
//                .ok()
//                .body(productsService.getOnlyThisMerchantProducts());
//    }

    @PostMapping("/merchant/saveproduct")
    public ResponseEntity<ProductsDto> createProduct(@RequestBody ProductsDto ProductsDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productsService.saveProducts(ProductsDto));
    }


//    @PutMapping("/")
//    public ResponseEntity<ProductsDto> updateProduct(@RequestBody ProductsDto ProductsDto) {
//        productsService.updateProducts(ProductsDto);
//        return ResponseEntity.ok(ProductsDto);
//    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Object> deletemerchant(@PathVariable String merchantname) {
//        productsService.deleteOneProducts(merchantname);
//        return ResponseEntity
//                .status(HttpStatus.NO_CONTENT)
//                .body("merchant " + merchantname + " deleted succesfully");
//    }


}
