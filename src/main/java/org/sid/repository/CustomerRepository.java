package org.sid.repository;

import jakarta.persistence.Id;
import org.sid.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Id> {

   Optional<Customer> findById(Long Id);
   public Page<Customer> findByNameContains(String mc, Pageable pageable);
}
