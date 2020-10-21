package io.abhithube.plandetailsservice.service;

import io.abhithube.plandetailsservice.exception.PlanNotFoundException;
import io.abhithube.plandetailsservice.model.Plan;
import io.abhithube.plandetailsservice.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Plan getPlan(String id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException(id));
    }
}