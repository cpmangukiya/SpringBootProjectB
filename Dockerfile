FROM openjdk:8-oraclelinux7
MAINTAINER Chintan
COPY target/SpringBootProjectB-1.0-SNAPSHOT.jar SpringBootProjectB-1.0-SNAPSHOT.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","/SpringBootProjectB-1.0-SNAPSHOT.jar"]