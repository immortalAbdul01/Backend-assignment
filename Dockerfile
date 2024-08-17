
FROM openjdk:17-jdk-slim

WORKDIR /app


COPY target/assignment-0.0.1-SNAPSHOT.jar /app/assignment-backend.jar


EXPOSE 2000


ENTRYPOINT ["java", "-jar", "/app/assignment-backend.jar"]
