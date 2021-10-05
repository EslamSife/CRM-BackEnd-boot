package com.pet.clinic.crm.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "summary")
    private String summary;

    @Column(name = "service_description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private Set<TicketItem> ticketItems;

    public Service() {
    }

    public Service(Integer serviceId, String serviceName, String summary, String description, BigDecimal price, Date lastUpdated, Set<TicketItem> ticketItems) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.summary = summary;
        this.description = description;
        this.price = price;
        this.lastUpdated = lastUpdated;
        this.ticketItems = ticketItems;
    }



    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", lastUpdated=" + lastUpdated +
                ", ticketItems=" + ticketItems +
                '}';
    }
}
