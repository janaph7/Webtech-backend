#
# Build stage
#
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="janaph7"
LABEL authors="jana pham, elisa khoury"
#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
COPY --from=builder /build/libs/webtechbackend-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/webtechbackend-0.0.1-SNAPSHOT.jar"]
