# Stage 1: build with Maven + JDK 21
FROM maven:3.9.4-jdk-21 AS build

WORKDIR /app

# Copy pom + source code
COPY pom.xml .
COPY src ./src

# Build the JAR (skip tests for speed)
RUN mvn clean package -DskipTests

# Stage 2: run the JAR in a slim JDK
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR from the first stage
COPY --from=build /app/target/scoreboard-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render sets PORT via env)
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
