package com.pet.clinic.crm.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "ticket_item")
@Getter
@Setter
public class TicketItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_item_id")
    private Integer id;

    @Column(name="payment_status")
    private String paymentStatus;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name="createdBy", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service  service;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", nullable = false)
    private TicketStatus ticketStatus;


    public TicketItem() {
    }

    public TicketItem(Integer id, String paymentStatus, BigDecimal unitPrice, Date dateCreated, Date lastUpdated, User user, Service service, Ticket ticket, TicketStatus ticketStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.unitPrice = unitPrice;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.user = user;
        this.service = service;
        this.ticket = ticket;
        this.ticketStatus = ticketStatus;
    }


}
