FROM adoptopenjdk/maven-openjdk11 AS build
WORKDIR app
COPY src src
COPY pom.xml .
RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build app/target/plan-details-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
ENTRYPOINT ["sh", "-c", "java -Dspring.data.mongodb.uri=${MONGO_URI} -jar /app.jar"]