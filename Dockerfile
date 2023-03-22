FROM openjdk:19-alpine
VOLUME /tmp
WORKDIR /app
COPY ./target/*.jar /app/spring-boot-demo.jar
ENTRYPOINT ["java","-jar","spring-boot-demo.jar"]