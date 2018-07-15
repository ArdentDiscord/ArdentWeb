FROM openjdk:8-jre-alpine

EXPOSE 443

RUN mkdir /ardent

COPY ./config /ardent
COPY ./ardent.jks /ardent

COPY ./build/libs/Ardent-Web-1.0-SNAPSHOT.jar /ardent

WORKDIR /ardent

ENTRYPOINT ["java", "-jar", "Ardent-Web-1.0-SNAPSHOT.jar", "config", "ardent.jks"]