package org.bitech.ecommerce.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ClientDto {

    @NotBlank(message = "The client name was not entered")
    private String name;
    @NotBlank(message = "The client userName was not entered")
    private String userName;
    @NotBlank(message = "The client password was not entered")
    private String password;
    private List<ShoppingCartDto> shoppingCarts;

}
