FROM openjdk:20-jdk-slim
VOLUME /tmp
WORKDIR /app
COPY ./target/*.jar /app/spring-boot-demo.jar
ENTRYPOINT ["java","-jar","spring-boot-demo.jar"]