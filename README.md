# Kotlin, Spring Boot, H2, JPA, Hibernate Rest API

Build a Restful CRUD API using Kotlin, Spring Boot, H2, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. H2 - 1.4+

## Steps to Setup

**1. Clone the application**

```bash
git@github.com:marleyiam/Kotin-Meetup-DF-Spring.git
```

**2. Create H2 database**
```bash
just use default testdb H2 database
```

**3. Use regular H2 crenditals already defined**

+ open `src/main/resources/application.properties`

**2. Running the App**

Type the following command in your terminal to run the app -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/articles
    
    POST /api/articles
    
    GET /api/articles/{id}
    
    PUT /api/articles/{id}
    
    DELETE /api/articles/{id}

You can test them using postman or any other rest client.

## Learn more

You can find the base tutorial for this application below -

<https://www.callicoder.com/kotlin-spring-boot-mysql-jpa-hibernate-rest-api-tutorial/>
