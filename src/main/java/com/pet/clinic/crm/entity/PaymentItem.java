package com.pet.clinic.crm.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="payment_item")
@Data
public class PaymentItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_item_id")
    private Integer paymentItemId;

    @OneToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "ticket_item_id")
    private TicketItem ticketItem;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;


    public PaymentItem() {
    }

    public PaymentItem(Integer paymentItemId, OrderItem orderItem, Payment payment, TicketItem ticketItem, BigDecimal unitPrice, Date dateCreated, Date lastUpdated) {
        this.paymentItemId = paymentItemId;
        this.orderItem = orderItem;
        this.payment = payment;
        this.ticketItem = ticketItem;
        this.unitPrice = unitPrice;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }



    @Override
    public String toString() {
        return "PaymentItem{" +
                "paymentItemId=" + paymentItemId +
                ", orderItem=" + orderItem +
                ", payment=" + payment +
                ", ticketItem=" + ticketItem +
                ", unitPrice=" + unitPrice +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }




}