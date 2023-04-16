# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-slim-buster

ARG JAR_FILE

# Set the working directory to /app
WORKDIR /app

# Copy the executable jar into the container at /app
COPY ${JAR_FILE}  /app/app.jar
COPY src/main/resources/data/rickandmortycharacter.json /app/src/main/resources/data/rickandmortycharacter.json

# Set environment variables for the JVM
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the executable jar when the container starts
CMD ["java", "-jar", "app.jar"]
