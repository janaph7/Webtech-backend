FROM gradle:8-jdk11 as builder
WORKDIR /
COPY . ./
RUN gradle build --info

FROM openjdk:11-slim
LABEL authors="jana pham, elisa khoury"
COPY --from=builder /build/libs/webtechbackend-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/webtechbackend-0.0.1-SNAPSHOT.jar"]