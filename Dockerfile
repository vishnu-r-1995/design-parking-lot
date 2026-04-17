# =============================================
# Stage 1: Build the JAR using Maven
# =============================================
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# =============================================
# Stage 2: Lightweight runtime with debug support
# =============================================
FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app

# Copy only the built JAR
COPY --from=build /app/target/design-parking-lot-1.0-SNAPSHOT.jar app.jar

# Enable remote debugging on port 5005
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005"

EXPOSE 5005

ENTRYPOINT ["java", "-jar", "app.jar"]