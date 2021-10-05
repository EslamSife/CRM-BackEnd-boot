package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
