package org.bitech.ecommerce.model.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShCartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    @JoinColumn(name = "id_shoppingCart")
    public ShoppingCart shoppingCart;
    @ManyToOne
    @JoinColumn(name = "id_product")
    public Product product;
    public int cant;

}
