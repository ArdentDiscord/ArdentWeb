FROM openjdk:8-jre-slim

RUN mkdir /ardent

COPY ./config /ardent
COPY ./build/libs/Ardent-1.0-SNAPSHOT.jar /ardent

WORKDIR /ardent

ENTRYPOINT ["java", "-jar", "Ardent-Web-1.0-SNAPSHOT.jar", "config"]