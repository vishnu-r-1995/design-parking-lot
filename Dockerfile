# =============================================
# Stage 1: Build the JAR using Maven
# =============================================
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and source code
COPY pom.xml .
COPY src ./src

# Build the application (skips tests for speed)
RUN mvn clean package -DskipTests

# =============================================
# Stage 2: Lightweight runtime image
# =============================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy only the built JAR from the build stage
COPY --from=build /app/target/design-parking-lot-1.0-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]