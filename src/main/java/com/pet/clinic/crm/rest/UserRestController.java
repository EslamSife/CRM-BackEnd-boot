package com.pet.clinic.crm.rest;



import com.pet.clinic.crm.entity.User;
import com.pet.clinic.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class UserRestController {


    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("user id not exist on database - " + userId);
        }

        return user;
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {
        theUser.setUserId(0);
        userService.save(theUser);
        return theUser;
    }


    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {
        userService.save(theUser);
        return theUser;
    }



    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        // check first if user existed on DATABASE
        User user = userService.findById(userId);

        // throw Exception if null
        if(user == null) {
            throw new RuntimeException("user id not exist on database - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }

}
