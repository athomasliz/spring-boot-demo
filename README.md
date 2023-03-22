[spring-boot-demo]

https://www.bezkoder.com/docker-compose-spring-boot-mysql/

DOCKER_BUILDKIT=0 docker build --platform linux/amd64 .
docker build --platform linux/amd64 --build-arg JAR_FILE=target/\*.jar -t org.irushu/spring-boot-demo .
docker build --platform linux/amd64 -t org.irushu/spring-boot-demo .
docker network create springboot-mysql-net

docker-compose -f docker-compose-ALL.yml up
docker-compose -f docker-compose-ALL.yml down