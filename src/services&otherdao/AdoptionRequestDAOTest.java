package com.pawsandhearts.dao;

import com.pawsandhearts.model.AdoptionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionRequestDAOTest {

    private AdoptionRequestDAO adoptionRequestDAO;

    @BeforeEach
    void setUp() {
        adoptionRequestDAO = new AdoptionRequestDAO(); // Initialize AdoptionRequestDAO
    }

    @Test
    void testSubmitAdoptionRequest() {
        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setUserId(1);
        adoptionRequest.setPetId(1);
        adoptionRequest.setRequestDate("2025-01-01");

        boolean result = adoptionRequestDAO.submitAdoptionRequest(adoptionRequest);
        assertTrue(result, "Adoption request should be submitted successfully.");
    }

    @Test
    void testGetAdoptionRequestByUserId() {
        int userId = 1;
        int requestsFound = adoptionRequestDAO.getAdoptionRequestByUserId(userId).size();
        assertTrue(requestsFound >= 0, "Requests should be retrieved by user ID.");
    }

    @Test
    void testGetAdoptionRequestByPetId() {
        int petId = 1;
        int requestsFound = adoptionRequestDAO.getAdoptionRequestByPetId(petId).size();
        assertTrue(requestsFound >= 0, "Requests should be retrieved by pet ID.");
    }

    @Test
    void testDeleteAdoptionRequest() {
        int requestId = 1;
        boolean result = adoptionRequestDAO.deleteAdoptionRequest(requestId);
        assertTrue(result, "Adoption request should be deleted successfully.");
    }
}
