# Endterm Project – Spring Boot REST API

## Project Overview
This project is based on **Assignment 3** and **Assignment 4**.  .  
In this assignment, the project was converted into a **Spring Boot REST API**.

Project theme: **Space Exploration System** inspired by Lethal Company

Main entities:
- Planet
- Mission
- SalvageItem

The system works with a database and provides CRUD operations using REST.


## Architecture


- **Controller** – handles HTTP requests
- **Service** – contains business logic and validation
- **Repository** – works with the database using JDBC
- **Model** – entity classes


## REST API

### Planet
- POST `/planets` – create a planet  
- GET `/planets` – get all planets  
- GET `/planets/{id}` – get planet by id  
- PUT `/planets/{id}` – update planet  
- DELETE `/planets/{id}` – delete planet  

### Mission
- POST `/missions` – create a mission  
- GET `/missions` – get all missions  
- GET `/missions/{id}` – get mission by id  
- PUT `/missions/{id}` – update mission  
- DELETE `/missions/{id}` – delete mission  

### SalvageItem
- POST `/salvage-items` – create salvage item  
- GET `/salvage-items` – get all salvage items  
- GET `/salvage-items/{id}` – get salvage item by id  
- PUT `/salvage-items/{id}` – update salvage item  
- DELETE `/salvage-items/{id}` – delete salvage item  

## Design Patterns

### Singleton
Used for database configuration.  
Ensures only one database connection instance is created.

### Factory
Used to create different types of `SalvageItem`.  
Returns the base type and allows easy extension.

### Builder
Used to create complex objects with many optional fields.


## SOLID Principles
- **SRP** – each class has only one responsibility  
- **OCP** – new functionality can be added without modifying existing code  
- **LSP** – subclasses can be used through base class references  
- **ISP** – small and focused interfaces  
- **DIP** – services depend on repository interfaces, not implementations  


## Database
PostgreSQL is used as the database.

Tables:
- planets
- missions (linked to planets)
- salvage_items (linked to missions)


## Exception Handling
All exceptions are handled using a global exception handler and returned as HTTP responses.


## How to Run
1. Create a PostgreSQL database  
2. Configure `application.properties`  
3. Run `Application.java`  
4. Test the API using Postman or a browser  

The UML diagram is located in:

