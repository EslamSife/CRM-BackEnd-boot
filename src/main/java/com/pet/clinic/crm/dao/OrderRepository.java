package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
