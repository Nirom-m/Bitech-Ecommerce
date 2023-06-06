package org.bitech.ecommerce.model.repository;

import com.bitech.ecommerce.model.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
