[mysql]
https://geshan.com.np/blog/2022/02/mysql-docker-compose/
mkdir /tmp/mysql-data
docker run --name mysql-docker --rm -v /tmp/mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=Abcd12345678 -e MYSQL_DATABASE=demo -p 3306:3306 -it mysql:8.0.32
docker exec -it mysql-docker /bin/bash
mysql -uroot -p
show databases;
docker stop mysql-docker

docker-compose -f docker-compose-mysql-only.yml up
docker-compose -f docker-compose-mysql-only.yml down

[spring-boot-demo]