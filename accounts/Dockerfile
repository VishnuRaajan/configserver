#Starts with the base image containing Java runtime
FROM amazoncorretto:17.0.13-al2023-headless

#Information around who maintains the image
MAINTAINER "VishnuRaajan"

#Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]