FROM ubuntu:latest
LABEL authors="janapham"

ENTRYPOINT ["top", "-b"]

FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle build /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/EUER-PROJEKTNAME-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]