package org.bitech.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ShoppingCartDto {

    @NotNull
    private ClientDto client;
    private List<ShCartDetailDto> details;

}
