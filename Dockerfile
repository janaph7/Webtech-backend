FROM gradle:8-jdk21 as builder
WORKDIR /
COPY . ./
RUN gradle build

FROM openjdk:21-slim
LABEL authors="jana pham, elisa khoury"
COPY --from=builder /build/libs/webtechbackend-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]