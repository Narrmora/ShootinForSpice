# Use Eclipse Temurin JDK 21 (official, supported, works on Docker Hub)
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built JAR from Maven target
COPY target/scoreboard-0.0.1-SNAPSHOT.jar app.jar

# Expose the port from Spring Boot (Render will set PORT)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]