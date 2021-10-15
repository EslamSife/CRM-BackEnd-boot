package com.pet.clinic.crm.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "reference_number")
    private String referenceNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "ticket_status_id", nullable = false)
    private TicketStatus ticketStatus;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;


    @Column(name = "total_price")
    private BigDecimal totalPrice;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private Set<TicketItem> ticketItems;


    public Ticket() {
    }

    public Ticket(Integer ticketId, String referenceNumber, Customer customer, User user, TicketStatus ticketStatus, Date dateCreated, Date lastUpdated, BigDecimal totalPrice, Set<TicketItem> ticketItems) {
        this.ticketId = ticketId;
        this.referenceNumber = referenceNumber;
        this.customer = customer;
        this.user = user;
        this.ticketStatus = ticketStatus;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.totalPrice = totalPrice;
        this.ticketItems = ticketItems;
    }


    public void add(TicketItem item) {
        if (item != null) {
            if (ticketItems == null) {
                ticketItems = new HashSet<>();
            }
            ticketItems.add(item);
            item.setTicket(this);
        }
    }




}
