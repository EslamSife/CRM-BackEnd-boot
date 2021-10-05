package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
