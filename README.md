# Simple User Store - userstore-api


## Technology Used for Development

1. Java - 1.8

2. Gradle - 7.3

3. Postgres - 14

4. Spring Boot - 2.6.7

5. Flyway - 8.5.9


-	How to configure and run an application for simple user store

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/salahuddin09/userstore-api.git
```

**2. Create Postgres database**
```
create database userstore
```

**3. Change postgres username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your postgres installation

**4. Build and run the app using gradle**

The application uses gradle as a build tool. To build and run go to project directory and simply execute:

```
./gradlew build
./gradlew bootRun
```
It can be then accessed at `localhost:8080`.


