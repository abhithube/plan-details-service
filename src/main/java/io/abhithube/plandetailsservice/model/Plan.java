package io.abhithube.plandetailsservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plans")
@Getter
@Setter
@NoArgsConstructor
public class Plan {
    @Id
    private String id;
    private String name;
    private long cost;
    private long deductible;

    private String productId;
    private String priceId;
}
