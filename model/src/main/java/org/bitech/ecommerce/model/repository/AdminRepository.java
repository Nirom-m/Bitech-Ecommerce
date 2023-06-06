package org.bitech.ecommerce.model.repository;

import com.bitech.ecommerce.model.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
