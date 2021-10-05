package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
