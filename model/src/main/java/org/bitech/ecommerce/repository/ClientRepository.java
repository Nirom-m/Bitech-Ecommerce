package org.bitech.ecommerce.repository;


import org.bitech.ecommerce.model.Client;
import org.bitech.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Client findClientById(int id);
}
