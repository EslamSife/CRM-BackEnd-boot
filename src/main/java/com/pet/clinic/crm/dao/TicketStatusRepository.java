package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {
}
