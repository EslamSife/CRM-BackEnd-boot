package com.pet.clinic.crm.controller;


import com.pet.clinic.crm.dao.UserRepository;
import com.pet.clinic.crm.dto.UserModel;
import com.pet.clinic.crm.dto.UserResponse;
import com.pet.clinic.crm.entity.User;
import com.pet.clinic.crm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/staff")
public class StaffController {


    private StaffService staffService;
    private UserRepository userRepository;

    @Autowired
    public StaffController(StaffService staffService, UserRepository userRepository) {
        this.staffService = staffService;
        this.userRepository = userRepository;
    }


    @PostMapping("/createStaff")
    public UserResponse createStaff(@RequestBody UserModel userModel) {
        UserResponse userResponse = staffService.createStaff(userModel);
        return userResponse;
    }

    @GetMapping("/doctors")
    public List<User> getAllDoctors() {
        return this.userRepository.getAllDoctors();
    }
}
