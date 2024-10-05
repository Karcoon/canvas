FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/canvas-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} canvas-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/canvas-0.0.1-SNAPSHOT.jar"]

