package com.pets.pet;

import com.pets.pet.entities.Pet;
import com.pets.pet.repositories.PetRepository;
import com.pets.pet.services.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PetTest {
    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetService petService;

    @Test
    public void shouldAddPet(){
        Pet pet = new Pet("Sussi",2,"available");
        Pet savedPet = petService.addPet(pet);
        assertEquals("Sussi",pet.getName());
    }

    @Test
    public void shouldDeletePet(){
        Pet pet = new Pet("Sussi",2,"available");
        Pet savedPet = petService.addPet(pet);
        String deletedPet = petService.deletePet(pet.getId());
        assertEquals("La mascota fue eliminada con éxito",deletedPet);
    }

    @Test
    public void shouldUpdatePet(){
        Pet pet = new Pet("Sussi",2,"available");
        Pet savedPet = petService.addPet(pet);
        Pet updatePet = new Pet("Sussana",1,"available");
        Pet updatedPet = petService.updatePet(pet.getId(),updatePet);
    }

    @Test
    public void shouldGetPet(){
        Pet pet = new Pet("Sussi",2,"available");
        Pet savedPet = petService.addPet(pet);
        Pet getPet = petService.getPetById(pet.getId());
        assertEquals(getPet.getId(),pet.getId());
    }

    @Test
    public void shouldGetPets(){
        String status = "available";
        List<Pet> pets = petService.findPetsByStatus(status);
        pets.stream().forEach(x -> System.out.println(x.getStatus()));
        // assertEquals(true, pets.stream().allMatch(x->x.getStatus()=="available"));
    }
}
