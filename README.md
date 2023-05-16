# Spring Boot Basic (with OpenAPI 3 and Swagger)
Basic Spring boot with Rick and Morty data.

## Requirements

Java version 17

## Usage

### Maven

```
mvn clean install -DskipTests
```

### Docker

```
docker build --build-arg JAR_FILE=target/spring-boot-3-basic-1.0.0-SNAPSHOT.jar -t spring-rm .
```

```
docker run --name backend-spring-rm -p 8080:8080 -it spring-rm
```


### Swagger

```
http://localhost:8080/swagger-ui/index.html
```

### PgAdmin

```
docker ps 
```

```
docker inspect **CONTAINER_ID_POSTGRES** 
```

Get IPAddress in `NetworkSettings.NetWorks.IPAddress` and this is the connection;host/name

#### Tutorial:

https://www.postgresqltutorial.com/postgresql-getting-started/connect-to-postgresql-database/

### Docker compose

```
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/test_db
export SPRING_DATASOURCE_USERNAME=root
export SPRING_DATASOURCE_PASSWORD=root
export SPRING_JPA_HIBERNATE_DDL_AUTO=create
```

```
docker-compose up
```
