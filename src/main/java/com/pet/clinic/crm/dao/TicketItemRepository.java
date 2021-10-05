package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketItemRepository extends JpaRepository<TicketItem, Integer> {
}
