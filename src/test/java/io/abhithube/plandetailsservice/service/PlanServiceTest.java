package io.abhithube.plandetailsservice.service;

import io.abhithube.plandetailsservice.exception.PlanNotFoundException;
import io.abhithube.plandetailsservice.model.Plan;
import io.abhithube.plandetailsservice.repository.PlanRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlanServiceTest {
    @InjectMocks
    private PlanService planService;
    @Mock
    private PlanRepository planRepository;

    @Test
    @DisplayName("it should retrieve all plans")
    void getAllPlans() {
        // Arrange
        Plan plan = new Plan();
        when(planRepository.findAll())
                .thenReturn(Arrays.asList(plan, new Plan()));

        // Act
        List<Plan> plans = planService.getAllPlans();

        // Assert
        assertEquals(2, plans.size());
        assertTrue(plans.contains(plan));
    }

    @Test
    @DisplayName("it should get a plan by id")
    void getPlan1() {
        // Arrange
        Plan p = new Plan();
        p.setId("plan123");
        when(planRepository.findById(anyString()))
                .thenReturn(Optional.of(p));

        // Act
        Plan plan = planService.getPlan("plan123");

        // Assert
        assertEquals("plan123", plan.getId());
    }

    @Test
    @DisplayName("it should throw an exception if a plan is not found")
    void getPlan2() {
        // Arrange
        when(planRepository.findById(anyString()))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PlanNotFoundException.class, () -> planService.getPlan("plan123"));
    }
}