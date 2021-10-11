package com.pet.clinic.crm.controller;


import com.pet.clinic.crm.dto.UserModel;
import com.pet.clinic.crm.dto.UserResponse;
import com.pet.clinic.crm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/staff")
public class StaffController {


    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @PostMapping("/createStaff")
    public UserResponse createStaff(@RequestBody UserModel userModel) {
        UserResponse userResponse = staffService.createStaff(userModel);
        return userResponse;
    }
}
