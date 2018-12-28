# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8090

# The application's jar file
ARG JAR_FILE=target/soundtrack-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} soundtrack.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/soundtrack.jar"]

# Docker setup steps

# 1. `docker login` to setup account
# 2. `docker build -t soundtrack .` to build the docker image
# 3. `docker run -p 8090:8090 soundtrack` to run the application

# Extras Commands
# `docker ps` to see the processes running
# `docker exec -it`