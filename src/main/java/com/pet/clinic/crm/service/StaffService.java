package com.pet.clinic.crm.service;

import com.pet.clinic.crm.dto.UserModel;
import com.pet.clinic.crm.dto.UserResponse;

public interface StaffService {


    UserResponse createStaff(UserModel user);
}
