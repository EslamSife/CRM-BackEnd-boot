package com.pet.clinic.crm.dto;


import com.pet.clinic.crm.entity.*;
import lombok.Data;

@Data
public class Purchase {

    private Integer serviceId;
    private Ticket ticket;
    private TicketItem ticketItem;
    private Customer customer;
    private Pet pet;
    private Payment payment;
    private PaymentItem paymentItem;

}
