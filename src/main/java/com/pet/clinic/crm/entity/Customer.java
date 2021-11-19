package com.pet.clinic.crm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    // must be unique and not null, will use in search criteria for customer exist
    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;


    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "join_date")
    @CreationTimestamp
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private Set<Ticket> tickets;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private Set<Pet> pets;




    public Customer() {

    }

    public Customer(Integer customerId, String customerCode, String firstName, String lastName, String middleName, String mobile, String email, String address, Date joinDate, User user, Set<Ticket> tickets, Set<Pet> pets) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
        this.user = user;
        this.tickets = tickets;
        this.pets = pets;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", joinDate=" + joinDate +
                ", user=" + user +
                ", tickets=" + tickets +
                ", pets=" + pets +
                '}';
    }





    public void add(Pet pet) {
        if (pet != null) {
            if (pets == null) {
                pets = new HashSet<>();
            }
            pets.add(pet);
            pet.setOwner(this);
        }
    }


    public void add(Ticket ticket) {
        if (ticket != null) {
            if (tickets == null) {
                tickets = new HashSet<>();
            }
            tickets.add(ticket);
            ticket.setCustomer(this);
        }
    }

}
