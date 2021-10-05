package com.pet.clinic.crm.service;

import com.pet.clinic.crm.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int userId);

    void save(User user);

    void deleteById(int userId);
}
