package com.pet.clinic.crm.dto;


import com.pet.clinic.crm.entity.RoleType;
import lombok.Data;

@Data
public class UserModel {

    private String firstName;

    private String lastName;

    private String gender;

    private String middleName;

    private String userName;

    private String email;

    private String address;

    private String mobile;

    private String passwordHash;

    private RoleType roleType;
}
