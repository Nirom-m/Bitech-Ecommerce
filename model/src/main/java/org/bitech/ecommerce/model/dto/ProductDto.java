package org.bitech.ecommerce.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    @NotNull(message = "The product id was not entered")
    private int id;
    @NotBlank(message = "The product name was not entered")
    private String name;
    //private String reference;
    @NotBlank(message = "The product category was not entered")
    private String category;
    @NotNull(message = "The product cant was not entered")
    private int cant;
    @NotBlank(message = "The product photo was not entered")
    private String photo;

}
