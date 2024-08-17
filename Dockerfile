# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the build artifact from the host to the container
COPY target/assignment-0.0.1-SNAPSHOT.jar /app/assignment-backend.jar

# Expose the port your application runs on
EXPOSE 2000

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/assignment-backend.jar"]
