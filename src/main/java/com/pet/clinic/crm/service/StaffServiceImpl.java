package com.pet.clinic.crm.service;

import com.pet.clinic.crm.dao.UserRepository;
import com.pet.clinic.crm.dto.UserModel;
import com.pet.clinic.crm.dto.UserResponse;
import com.pet.clinic.crm.entity.RoleType;
import com.pet.clinic.crm.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StaffServiceImpl implements StaffService {


    private UserRepository userRepository;


    public StaffServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponse createStaff(UserModel userModel) {
        User user = mapUserModelToUserEntity(userModel);
        userRepository.save(user);
        return new UserResponse(user.getUserId());
    }


    private User mapUserModelToUserEntity(UserModel userModel) {
        User user = new User();
        // retrieve the user role type info from dto
        RoleType roleType = userModel.getRoleType();
        // map user model to user entity
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setGender(userModel.getGender());
        user.setMiddleName(userModel.getMiddleName());
        user.setUserName(userModel.getUserName());
        user.setAddress(userModel.getAddress());
        user.setEmail(userModel.getEmail());
        user.setMobile(userModel.getMobile());
        user.setRoleType(roleType);
        user.setPasswordHash(userModel.getPasswordHash());
        return user;
    }
}
