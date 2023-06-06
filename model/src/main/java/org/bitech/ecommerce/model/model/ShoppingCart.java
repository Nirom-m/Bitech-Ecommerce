package org.bitech.ecommerce.model.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ShoppingCart {
    @NotNull
    private Client client;
    private List<ShCartDetail> details;


}
