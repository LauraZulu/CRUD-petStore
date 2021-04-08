package com.pets.pet.service;

import com.pets.pet.dao.PetRepository;
import com.pets.pet.dto.Pet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;


    public Pet addPet(Pet pet){
        return petRepository.saveAndFlush(pet);
    }

    public String deletePet(Long id){
        String message = "La mascota fue eliminada con éxito";
        petRepository.deleteById(id);
        return message;
    }

    public List<Pet> findPetsByStatus(String status){
       List<Pet> a = petRepository.findByStatus(status);
       return a;
    }

    public Pet getPetById(Long id){ return petRepository.getById(id);}

    public Pet updatePet(Long id, Pet pet){
        Pet existingPet = petRepository.getById(id);
        BeanUtils.copyProperties(pet,existingPet,"id");
        return petRepository.saveAndFlush(existingPet);
    }
}
