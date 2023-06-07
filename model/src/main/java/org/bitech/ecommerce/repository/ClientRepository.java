package org.bitech.ecommerce.repository;


import org.bitech.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
