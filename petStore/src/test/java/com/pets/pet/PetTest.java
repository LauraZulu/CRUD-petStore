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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTest {
    @Mock
    PetRepository petRepositoryMock;

    @InjectMocks
    PetService petService;

    @Test
    public void shouldAddPet(){
        Pet pet = new Pet(2L,"Sussi",2,"available");
        when(petRepositoryMock.saveAndFlush(pet)).thenReturn(pet);
        Pet savedPet = petService.addPet(pet);
        assertEquals("Sussi",savedPet.getName());
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
        when(petRepositoryMock.getById(pet.getId())).thenReturn(updatePet);
        Pet updatedPet = petService.updatePet(pet.getId(),updatePet);
        assertEquals("Sussana",updatePet.getName());
    }

    @Test
    public void shouldGetPet(){
        Pet pet = new Pet("Sussi",2,"available");
        Pet savedPet = petService.addPet(pet);
        when(petRepositoryMock.getById(pet.getId())).thenReturn(pet);
        Pet getPet = petService.getPetById(pet.getId());
        assertEquals("Sussi",getPet.getName());
    }

    @Test
    public void shouldGetPetsStatus(){
        String status = "available";
        List<Pet> pets = petService.findPetsByStatus(status);
        assertEquals(true, pets.stream().allMatch(x->x.getStatus()=="available"));
    }
}
