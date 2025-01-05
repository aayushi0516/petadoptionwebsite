package com.pawsandhearts.dao;

import com.pawsandhearts.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetDAOTest {

    private PetDAO petDAO;

    @BeforeEach
    void setUp() {
        petDAO = new PetDAO(); // Initialize PetDAO
    }

    @Test
    void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(3);
        pet.setSize("Large");
        pet.setDescription("Friendly and playful");
        pet.setImageUrl("buddy.jpg");

        boolean result = petDAO.addPet(pet);
        assertTrue(result, "Pet should be added successfully.");
    }

    @Test
    void testGetPetById() {
        int petId = 1;
        Pet pet = petDAO.getPetById(petId);
        assertNotNull(pet, "Pet should be retrieved by ID.");
        assertEquals(petId, pet.getId(), "Pet ID should match.");
    }

    @Test
    void testGetPetsByType() {
        String petType = "Dog";
        int petsFound = petDAO.getPetsByType(petType).size();
        assertTrue(petsFound > 0, "There should be pets of the specified type.");
    }

    @Test
    void testUpdatePetDetails() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Updated Buddy");
        pet.setAge(4);

        boolean result = petDAO.updatePetDetails(pet);
        assertTrue(result, "Pet details should be updated successfully.");
    }

    @Test
    void testDeletePet() {
        int petId = 1;
        boolean result = petDAO.deletePet(petId);
        assertTrue(result, "Pet should be deleted successfully.");
    }
}
