package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.PaymentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentItemRepository extends JpaRepository<PaymentItem, Integer> {
}
