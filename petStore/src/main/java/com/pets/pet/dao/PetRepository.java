package com.pets.pet.dao;

import com.pets.pet.dto.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query("SELECT p FROM pets p WHERE p.status = ?1")
    List<Pet> findByStatus(String status);

}
