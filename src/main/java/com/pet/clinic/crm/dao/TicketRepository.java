package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
