package org.bitech.ecommerce.repository;

import org.bitech.ecommerce.model.Client;
import org.bitech.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {

    @Query("SELECT sc FROM ShoppingCart sc WHERE sc.id = :idCart and sc.client.id= :idClient ")
    ShoppingCart findShoppingCartByIdAndIdClient(int idCart, int idClient);
}
