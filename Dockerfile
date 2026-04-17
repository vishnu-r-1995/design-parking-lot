# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the JAR (skip tests during debug setup)
RUN mvn clean package -DskipTests

# Stage 2: Runtime with debug support
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/design-parking-lot-1.0-SNAPSHOT.jar app.jar

# Enable remote debugging on port 5005
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

EXPOSE 5005

ENTRYPOINT ["java", "-jar", "app.jar"]