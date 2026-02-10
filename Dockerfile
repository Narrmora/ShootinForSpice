# Use official OpenJDK 21 image
FROM openjdk:21-jdk-slim

# Copy the built JAR
COPY target/scoreboard-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]
