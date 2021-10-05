package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
