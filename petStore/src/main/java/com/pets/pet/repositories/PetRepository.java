package com.pets.pet.repositories;

import com.pets.pet.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query("SELECT p FROM pets p WHERE p.status = ?1")
    List<Pet> findByStatus(String status);

}
