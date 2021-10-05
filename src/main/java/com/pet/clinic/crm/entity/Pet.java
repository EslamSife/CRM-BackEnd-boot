package com.pet.clinic.crm.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "join_date")
    @CreationTimestamp
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Customer owner;

    public Pet() {
    }

    public Pet(Integer petId, String name, Integer age, String gender, Date joinDate, Customer owner) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.joinDate = joinDate;
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", joinDate=" + joinDate +
                ", owner=" + owner +
                '}';
    }
}
