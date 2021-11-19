package com.pet.clinic.crm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ticket_status")
@Getter
@Setter
public class TicketStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketStatus")
    @JsonIgnore
    private Set<Ticket> tickets;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketStatus")
    @JsonIgnore
    private Set<TicketItem> ticketItems;

    public TicketStatus() {
    }

    public TicketStatus(Integer statusId, String statusName, Set<Ticket> tickets, Set<TicketItem> ticketItems) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.tickets = tickets;
        this.ticketItems = ticketItems;
    }




    @Override
    public String toString() {
        return "TicketStatus{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", tickets=" + tickets +
                ", ticketItems=" + ticketItems +
                '}';
    }
}
