# Use the full Maven + JDK 21 image for building and running
FROM maven:3.9.4-eclipse-temurin-21

WORKDIR /app

# Copy pom + source code
COPY pom.xml .
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Run the app
ENTRYPOINT ["java","-jar","target/scoreboard-0.0.1-SNAPSHOT.jar"]

# Expose port (Render sets PORT via env)
EXPOSE 8080
