# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app
COPY . .

# Build the project and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Run with minimal JRE
FROM eclipse-temurin:21-jre-alpine

# Create app directory
WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (optional, usually 8080 for Spring Boot)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]