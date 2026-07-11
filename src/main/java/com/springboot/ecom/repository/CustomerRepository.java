package com.springboot.ecom.repository;

import com.springboot.ecom.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

@Query("""
        SELECT c
        FROM Customer c
        WHERE c.is_active = true
        """)
Page<Customer> fetchAll(Pageable pageable);


    @Query("""
       SELECT c
       FROM Customer c
       WHERE c.id = ?1
       AND c.is_active = true
       """)
    Optional<Customer> fetchById(long id);
}
