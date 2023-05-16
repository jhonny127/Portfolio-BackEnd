FROM amazoncorretto:17-alpine-jdk
MAINTAINER Jhonny
COPY target/jh-0.0.1-SNAPSHOT.jar jh-app.jar
ENTRYPOINT ["java","-jar","/jh-app.jar"]
