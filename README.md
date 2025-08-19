🧑‍💻 User Management Application (Spring Boot)

A simple yet production-ready CRUD REST API for managing users, built with Spring Boot.
This project demonstrates clean architecture with Controller-Service-Repository layers, DTO usage, validation, and exception handling — making it closer to real-world production projects.

🚀 Features

Create new users

Get all users

Get user by ID

Update user details

Delete user

DTOs for request/response

Input validation (e.g., email format, non-empty fields, min length)

Global exception handling with custom error responses

Clean layered architecture

🛠️ Tech Stack

Backend: Java 17+, Spring Boot

Build Tool: Maven

Database: MySQL

ORM: Spring Data JPA (Hibernate)

Validation: Jakarta Validation API

📂 Project Structure

src/main/java/com/example/userapp/
│
├── controller/ # REST Controllers
├── service/ # Business Logic
├── repository/ # JPA Repositories
├── model/ # Entity Classes
├── dto/ # Request/Response DTOs
├── exception/ # Custom Exceptions + GlobalExceptionHandler
└── UserAppApplication.java

1️⃣ Clone the repository

git clone https://github.com/MrNish/User_app.git
cd User_app

2️⃣ Configure database

In src/main/resources/application.properties, configure MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the app

mvn spring-boot:run

📌 API Endpoints

Create User
POST /api/users
Request Body:
{
  "name": "John Doe",
  "email": "john@example.com",
  "age": 25
}

Get All Users
GET /api/users

Get User by ID
GET /api/users/{id}

Update User
PUT /api/users/{id}
Request Body:
{
  "name": "Updated Name",
  "email": "updated@example.com",
  "age": 30
}

Delete User
DELETE /api/users/{id}

🛡️ Validation Examples

"email": "" → ❌ Email cannot be blank

"email": "invalidemail" → ❌ Must be a valid email format

"name": "" → ❌ Name cannot be blank
