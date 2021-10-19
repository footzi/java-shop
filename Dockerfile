FROM openjdk:8-jdk-alpine

#ENV APP_HOME=/usr/app/
#
#WORKDIR $APP_HOME

COPY target/shop-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]