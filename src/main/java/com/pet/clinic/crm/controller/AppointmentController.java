package com.pet.clinic.crm.controller;

import com.pet.clinic.crm.dao.TicketItemRepository;
import com.pet.clinic.crm.dao.TicketRepository;
import com.pet.clinic.crm.entity.Ticket;
import com.pet.clinic.crm.entity.TicketItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {



    private TicketItemRepository ticketItemRepository;

    @Autowired
    public AppointmentController(TicketItemRepository ticketItemRepository) {
        this.ticketItemRepository = ticketItemRepository;
    }


    @GetMapping("ticket")
    public List<TicketItem> getTickets() {
        return this.ticketItemRepository.findAll();
    }
}
