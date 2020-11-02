package io.abhithube.plandetailsservice.controller;

import io.abhithube.plandetailsservice.model.Plan;
import io.abhithube.plandetailsservice.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/plans", produces = "application/json")
@Api(tags = "Plan Details Resource", description = "Defines the retrieval operations associated with benefit plans")
public class PlanController {
    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    @ApiOperation("Retrieves all plans as a list")
    public ResponseEntity<List<Plan>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieves a plan by ID")
    public ResponseEntity<Plan> getPlan(@ApiParam(value = "The ID of a plan to query for",
            example = "5f7d1145c5288a5ffdc6e1e8") @PathVariable String id) {
        return ResponseEntity.ok(planService.getPlan(id));
    }
}
