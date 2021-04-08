package com.pets.pet.controllers;

import com.pets.pet.entities.Pet;
import com.pets.pet.request.PetRequest;
import com.pets.pet.services.PetService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    Mapper mapper;

    @GetMapping("findByStatus/{status}")
    public List<Pet> findPetsByStatus(@PathVariable String status) {
        return petService.findPetsByStatus(status);
    }

    @GetMapping("{id}")
    public Pet getPetById(@PathVariable Long id){
        return petService.getPetById(id);
    }

    @PostMapping
    public Pet addPet(@RequestBody PetRequest petRequest){
        Pet pet = mapper.map(petRequest,Pet.class);
        return petService.addPet(pet);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deletePet(@PathVariable Long id){ return petService.deletePet(id);}

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet){
        return petService.updatePet(id,pet);
    }
}
