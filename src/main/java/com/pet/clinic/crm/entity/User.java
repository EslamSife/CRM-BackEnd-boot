package com.pet.clinic.crm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "join_date")
    @CreationTimestamp
    private Date joinDate;

    @Column(name = "leave_date")
    @CreationTimestamp
    private Date leaveDate;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "last_login")
    @CreationTimestamp
    private Date lastLogin;

    @ManyToOne
    @JoinColumn(name = "role_type", nullable = false)
    private RoleType roleType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<Ticket> ticket;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<Customer> customers;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<TicketItem> ticketItems;

    public User() {
    }

    public User(Integer userId, String firstName, String lastName, String middleName, String userName, String email, String mobile, Date joinDate, Date leaveDate, String passwordHash, Date lastLogin, RoleType roleType, Set<Ticket> ticket, Set<Customer> customers, Set<TicketItem> ticketItems) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
        this.passwordHash = passwordHash;
        this.lastLogin = lastLogin;
        this.roleType = roleType;
        this.ticket = ticket;
        this.customers = customers;
        this.ticketItems = ticketItems;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", joinDate=" + joinDate +
                ", leaveDate=" + leaveDate +
                ", passwordHash='" + passwordHash + '\'' +
                ", lastLogin=" + lastLogin +
                ", roleType=" + roleType +
                ", ticket=" + ticket +
                ", customers=" + customers +
                ", ticketItems=" + ticketItems +
                '}';
    }
}
