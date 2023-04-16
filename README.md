# Spring Boot Basic (with OpenAPI 3 and Swagger)


## Usage 

### Maven


```
mvn clean install
```

### Docker

```
docker build --build-arg JAR_FILE=target/spring-boot-3-basic-0.0.1-SNAPSHOT.jar -t spring-rm .
```

```
docker run --name backend-spring-rm -p 8080:8080 -it spring-rm
```

