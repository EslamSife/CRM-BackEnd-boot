package com.pet.clinic.crm.dao;


import com.pet.clinic.crm.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
