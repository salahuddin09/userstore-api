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

API Details

POST
- Create user

```
http://localhost:8080/api/userstore/users/ 

json
{
  "name": "Enter User Name",
  "country": "Enter Country Name"
}
```

GET
- Get User

```
http://localhost:8080/api/userstore/users/{user_id} 
```
PUT
- Update User by id

```
http://localhost:8080/api/userstore/users/{user_id} 

json
{
  "name": "Enter User Name",
  "country": "Enter Country Name"
}
```

POST
Add  UserProgress By UserId

```
http://localhost:8080/api/userstore/userprogress/{user_id} 

json
{
  "level": Enter Level e.g. 1,
  "score": Enter Score e.g 10.0
}
```

PUT
 Update UserProgress By UserId

```
http://localhost:8080/api/userstore/userprogress/{user_id} 

json
{
  "level": Enter Level e.g. 1,
  "score": Enter Score e.g 10.0
}
```

GET
Get User Progress By UserId

```
http://localhost:8080/api/userstore/userprogress/{user_id} 
```

GET
- Get list of 10 user progress based on top score value.

```
http://localhost:8080/api/userstore/leaderboard/users/
```

GET
 - Get user score by user id

```
http://localhost:8080/api/userstore/leaderboard/user/{user_id} 
```














