package io.abhithube.plandetailsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {
    @Bean
    public UiConfiguration uiConfiguration() {
        String[] supportedMethods = { "get" };
        return UiConfigurationBuilder.builder()
                .supportedSubmitMethods(supportedMethods)
                .docExpansion(DocExpansion.LIST)
                .operationsSorter(OperationsSorter.METHOD)
                .deepLinking(false)
                .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.abhithube"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Plan Details Service - API Documentation")
                .description("Details the REST API for the plan-details microservice of the AT Insurance application")
                .version("1.0")
                .build();
    }
}
