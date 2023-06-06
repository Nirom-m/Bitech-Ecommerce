package org.bitech.ecommerce.model.repository;

import org.bitech.ecommerce.model.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
