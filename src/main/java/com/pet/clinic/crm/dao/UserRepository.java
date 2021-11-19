package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "SELECT * FROM user u WHERE u.role_type = 2", nativeQuery=true)
    public List<User> getAllDoctors();

}
