package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
