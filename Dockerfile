FROM amazoncorretto:17-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ARG SPRING_PROFILE=local
ENV SPRING_PROFILE=$SPRING_PROFILE

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILE}", "-jar", "/app.jar"]