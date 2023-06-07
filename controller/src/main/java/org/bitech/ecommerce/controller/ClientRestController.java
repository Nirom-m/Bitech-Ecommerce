package org.bitech.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bitech.ecommerce.config.Constants;
import org.bitech.ecommerce.dto.ProductDto;
import org.bitech.ecommerce.model.Product;
import org.bitech.ecommerce.useCase.ClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientUseCase clientUseCase;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products= clientUseCase.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, String>> addToCart(@RequestBody @Valid ProductDto productDto,
                                                         @RequestParam("cant") int cant, @RequestParam("idClient") int idClient,
                                                         @RequestParam(value="idCart", required = false) Integer idCart){
        clientUseCase.addToCart(productDto, cant, idClient, idCart);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PRODUCT_ADD_TO_CART_MESSAGE));
    }
    @GetMapping("/productsAddCart/{idCart}/{idClient}")
    public ResponseEntity<List<String>> getProductsAddToCart(@PathVariable("idCart") int idCart, @PathVariable("idClient") int idClient) {
        List<String> products= clientUseCase.getProductsAddToCart(idCart, idClient);
        return ResponseEntity.ok(products);
    }

}
