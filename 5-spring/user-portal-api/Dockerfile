# declare the base image - here is a light weight JDK 8 setup
FROM openjdk:8-jdk-alpine

# copy the generate JAR into the container to run
COPY /target/user-portal-api.jar user-portal-api.jar

# Expose port 5000 of the container
EXPOSE 5000

# Run the JAR when we run the container, thus executing the app
ENTRYPOINT ["java", "-jar", "user-portal-api.jar"]
