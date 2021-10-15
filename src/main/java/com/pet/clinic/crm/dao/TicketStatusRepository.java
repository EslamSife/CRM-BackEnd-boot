package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "ticketStatus" , path = "ticketStatus")
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {
}
