package com.pet.clinic.crm.service;

import com.pet.clinic.crm.dao.UserRepository;
import com.pet.clinic.crm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int userId) {
        Optional<User> result = userRepository.findById(userId);
        User theUser = null;
        if(result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("did not find the user id - " + userId);
        }
        return theUser;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }
}
