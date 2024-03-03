# Stage 1: Build the application
FROM maven:3.9.6-amazoncorretto-21-al2023 AS build
WORKDIR /app
COPY pom.xml /app/
COPY src /app/src
RUN mvn clean package -DskipTests=true && java -Djarmode=layertools -jar /app/target/customer-service.jar extract

# Stage 2 (Runtime)
FROM amazoncorretto:21.0.2-alpine3.19
WORKDIR /app
COPY --from=build /app/dependencies/ /app/dependencies/
COPY --from=build /app/spring-boot-loader/ /app/sb-loader/
COPY --from=build /app/snapshot-dependencies/ /app/snapshots/
COPY --from=build /app/target/customer-service.jar /app/
EXPOSE 8080
CMD ["java", "-jar", "/app/customer-service.jar"]
