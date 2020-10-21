package io.abhithube.plandetailsservice.repository;

import io.abhithube.plandetailsservice.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanRepository extends MongoRepository<Plan, String> {
}
