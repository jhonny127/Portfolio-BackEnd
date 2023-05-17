FROM amazoncorretto:17
MAINTAINER Jhonny
COPY target/jh-0.0.1-SNAPSHOT.jar jh-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/jh-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080