package org.bitech.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bitech.ecommerce.config.Constants;
import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.useCase.AdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {

    private final AdminUseCase adminUseCase;

    @PostMapping()
    public ResponseEntity<Map<String, String>> createProduct(@RequestBody @Valid ProductDto productDto){
        adminUseCase.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PRODUCT_CREATED_MESSAGE));
    }

    @PutMapping()
    public ResponseEntity<Map<String, String>> modifyProduct (@RequestBody @Valid ProductDto productDto){
        adminUseCase.modifyProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PRODUCT_MODIFIED_MESSAGE));
    }
    @DeleteMapping()
    public ResponseEntity<Map<String, String>> deleteProduct (@RequestBody @Valid ProductDto productDto){
        adminUseCase.deleteProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PRODUCT_DELETED_MESSAGE));
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products= adminUseCase.getProducts();
        return ResponseEntity.ok(products);
    }
}
