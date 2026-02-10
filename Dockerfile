# Use Maven + JDK 21 image
FROM maven:3.9.3-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom + source code
COPY pom.xml .
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Second stage: slim JDK to run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built JAR from previous stage
COPY --from=build /app/target/scoreboard-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]
