# Plan Details Service [![Build Status](https://travis-ci.com/abhithube/plan-details-service.svg?branch=master)](https://travis-ci.com/abhithube/plan-details-service) ![Uptime Robot status](https://img.shields.io/uptimerobot/status/m786310888-e72a74101e97560d6bbf571e?label=status)


This is the plan-details microservice of the AT Insurance web application. It defines the REST API for retrieving a benefit plan's details.

The [README](https://github.com/abhithube/insurance-portal-angular) in the front end repo has more details about the whole project.

**NOTE:** To save on AWS server costs, the application is only up during the day. A cron job scheduler on AWS auto-scaling terminates all of the EC2 instances every night, and start them up again in the morning. The "status" badge at the top indicates if the application is currently up.

## API Documentation
The API documentation for this microservice was generated using Swagger. It can be found at https://at-insurance.com/plan-details-service/swagger-ui/.

## Technologies
- **Programming Language**: Java
- **Framework**: Spring Boot
- **DBMS**: MongoDB
- **Testing**: JUnit, Mockito
- **Build**: Maven
- **CI/CD**: Travis CI, Docker, AWS
