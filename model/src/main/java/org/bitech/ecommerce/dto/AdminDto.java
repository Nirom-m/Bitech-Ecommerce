package org.bitech.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Getter
public class AdminDto {

    @NotBlank(message = "The admin userName was not entered")
    private String userName;
    @NotBlank(message = "The admin password was not entered")
    private String password;
    private List<ProductDto> products;

}
