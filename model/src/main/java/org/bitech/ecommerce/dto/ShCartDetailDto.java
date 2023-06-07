package org.bitech.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class ShCartDetailDto {

    public ShoppingCartDto shoppingCart;
    public ProductDto product;
    @NotNull(message = "The product cant was not entered")
    @Min(value = 1, message = "The minimum quantity of the product must be 1")
    public int cant;

}
