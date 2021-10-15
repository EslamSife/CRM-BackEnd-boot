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
@Table(name="payment")
@Data
public class Payment {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "source_type")
    private String source;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
    private Set<PaymentItem> paymentItems;

    public Payment() {
    }

    public Payment(Integer paymentId, String referenceNumber, String paymentType, String source, Date dateCreated, Date lastUpdated, BigDecimal totalPrice, Ticket ticket, Order order, Set<PaymentItem> paymentItems) {
        this.paymentId = paymentId;
        this.referenceNumber = referenceNumber;
        this.paymentType = paymentType;
        this.source = source;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.totalPrice = totalPrice;
        this.ticket = ticket;
        this.order = order;
        this.paymentItems = paymentItems;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", source='" + source + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", totalPrice=" + totalPrice +
                ", ticket=" + ticket +
                ", order=" + order +
                ", paymentItems=" + paymentItems +
                '}';
    }


    public void add(PaymentItem paymentItem) {
        if (paymentItem != null) {
            if (paymentItems == null) {
                paymentItems = new HashSet<>();
            }
            paymentItems.add(paymentItem);
            paymentItem.setPayment(this);
        }
    }
}
