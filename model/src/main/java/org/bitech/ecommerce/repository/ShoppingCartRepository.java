package org.bitech.ecommerce.repository;

import org.bitech.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
