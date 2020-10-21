package io.abhithube.plandetailsservice.controller;

import io.abhithube.plandetailsservice.model.Plan;
import io.abhithube.plandetailsservice.service.PlanService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlanControllerTest {
    @InjectMocks
    private PlanController planController;
    @Mock
    private PlanService planService;

    @Test
    @DisplayName("it should retrieve all plans")
    void getAllPlans() {
        // Arrange
        Plan plan = new Plan();
        when(planService.getAllPlans())
                .thenReturn(Arrays.asList(plan, new Plan()));

        // Act
        ResponseEntity<List<Plan>> responseEntity = planController.getAllPlans();

        // Assert
        List<Plan> plans = responseEntity.getBody();

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(plans);
        assertEquals(2, plans.size());
        assertTrue(plans.contains(plan));
    }

    @Test
    @DisplayName("it should retrieve a plan by id")
    void getPlan() {
        // Arrange
        Plan in = new Plan();
        in.setId("plan123");

        when(planService.getPlan(anyString()))
                .thenReturn(in);

        // Act
        ResponseEntity<Plan> responseEntity = planController.getPlan("test");

        // Assert
        Plan out = responseEntity.getBody();

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(out);
        assertEquals("plan123", out.getId());
    }
}