package org.bitech.ecommerce.model.repository;

import org.bitech.ecommerce.model.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
