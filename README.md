## Instructions
### Setup
- Create an `.env` file on `\infra` with database configuration. This will be used by `docker-composer` to start the Database. The volume will be used to persist your data
```
TUITER_DB=DATABASE_NAME
TUITER_USER=USER_NAME
TUITER_PASSWORD=PASSWORD
TUITER_DATA="VOLUME_LOCATION"
```

- Create an `application-dev.properties` file on the project root. This will be the configuration for setting up the database connection
```
# Database Connection
spring.datasource.url=jdbc:postgresql://localhost:5432/DATABASE_NAME
spring.datasource.username=USER_NAME
spring.datasource.password=PASSWORD
```

### To start database using Docker 
- From infra folder:  
`
docker-compose -up -d
`

### To start Spring project
- From project root folder  
`
mvn spring-boot:run --define spring-boot.run.arguments="--spring.profiles.active=dev"
`