package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "ticketItem" , path = "ticketItem")
public interface TicketItemRepository extends JpaRepository<TicketItem, Integer> {
}
