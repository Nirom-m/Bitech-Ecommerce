package org.bitech.ecommerce.model.repository;

import com.bitech.ecommerce.model.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
