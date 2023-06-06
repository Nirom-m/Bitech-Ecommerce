package org.bitech.ecommerce.model.repository;

import com.bitech.ecommerce.model.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
