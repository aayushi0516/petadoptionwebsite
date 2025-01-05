package com.pawsandhearts.service;

import com.pawsandhearts.dao.PetDAO;
import com.pawsandhearts.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceTest {

    private PetService petService;
    private PetDAO petDAO;

    @BeforeEach
    void setUp() {
        petDAO = Mockito.mock(PetDAO.class);
        petService = new PetService(petDAO); // Inject mocked DAO
    }

    @Test
    void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Rex");
        pet.setType("Dog");
        pet.setBreed("German Shepherd");

        Mockito.when(petDAO.addPet(pet)).thenReturn(true);

        boolean result = petService.addPet(pet);
        assertTrue(result, "Pet should be added successfully.");
    }

    @Test
    void testUpdatePetDetails() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Updated Rex");

        Mockito.when(petDAO.updatePetDetails(pet)).thenReturn(true);

        boolean result = petService.updatePetDetails(pet);
        assertTrue(result, "Pet details should be updated successfully.");
    }

    @Test
    void testGetPetsByType() {
        String petType = "Dog";
        Mockito.when(petDAO.getPetsByType(petType)).thenReturn(null);

        var result = petService.getPetsByType(petType);
        assertNotNull(result, "Pets should be fetched by type.");
    }
}
