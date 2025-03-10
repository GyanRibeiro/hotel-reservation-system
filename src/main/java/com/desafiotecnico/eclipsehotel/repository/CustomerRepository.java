package com.desafiotecnico.eclipsehotel.repository;

import com.desafiotecnico.eclipsehotel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
