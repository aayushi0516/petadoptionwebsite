package com.pawsandhearts.service;

import com.pawsandhearts.dao.AdoptionRequestDAO;
import com.pawsandhearts.model.AdoptionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionRequestServiceTest {

    private AdoptionRequestService adoptionRequestService;
    private AdoptionRequestDAO adoptionRequestDAO;

    @BeforeEach
    void setUp() {
        adoptionRequestDAO = Mockito.mock(AdoptionRequestDAO.class);
        adoptionRequestService = new AdoptionRequestService(adoptionRequestDAO); // Inject mocked DAO
    }

    @Test
    void testSubmitAdoptionRequest() {
        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setUserId(1);
        adoptionRequest.setPetId(1);
        adoptionRequest.setRequestDate("2025-01-01");

        Mockito.when(adoptionRequestDAO.submitAdoptionRequest(adoptionRequest)).thenReturn(true);

        boolean result = adoptionRequestService.submitAdoptionRequest(adoptionRequest);
        assertTrue(result, "Adoption request should be submitted successfully.");
    }

    @Test
    void testDeleteAdoptionRequest() {
        int requestId = 1;
        Mockito.when(adoptionRequestDAO.deleteAdoptionRequest(requestId)).thenReturn(true);

        boolean result = adoptionRequestService.deleteAdoptionRequest(requestId);
        assertTrue(result, "Adoption request should be deleted successfully.");
    }
}
