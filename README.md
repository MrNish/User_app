
# 🧑‍💻 User Management Application (Spring Boot)

A **production-ready CRUD REST API** built with **Spring Boot** for efficient user management. This project features a clean layered architecture (Controller → Service → Repository), robust DTO validation, and global exception handling—ideal for real-world usage and scaling.

---

## 🚀 Features

- ➕ **Create new users**
- 📖 **Get all users**
- 🔍 **Get user by ID**
- ✏️ **Update user details**
- ❌ **Delete user**
- 📦 DTOs for request/response
- ✅ Input validation (email format, non-empty fields)
- 🛡️ Global exception handling with custom error responses
- 🗄️ Clean layered architecture

---

## 🛠️ Tech Stack

- **Backend:** Java 17+, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Validation:** Jakarta Validation API
- **Build Tool:** Maven

---

## ⚡ Getting Started

### 1️⃣ Clone the Repository

git clone https://github.com/MrNish/User_app.git

cd User_app


### 2️⃣ Configure Database

Update in `src/main/resources/application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/userdb

spring.datasource.username=root

spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true


### 3️⃣ Run the App

mvn spring-boot:run


## 📌 API Endpoints

| Method | Endpoint                   | Description          |
|--------|----------------------------|----------------------|
| POST   | `/users/addUser`           | Create new user      |
| GET    | `/users/getAllUsers`       | Get all users        |
| GET    | `/users/getUser?id=1`      | Get user by ID       |
| PUT    | `/users/updateUser/{id}`   | Update user          |
| DELETE | `/users/delete/{id}`       | Delete user          |

---

## 🛡️ Validation Rules

| Field   | Rule                      | Example Error                  |
|---------|---------------------------|-------------------------------|
| email   | Cannot be blank           | `"Email cannot be blank"`      |
| email   | Must be valid             | `"Must be a valid email format"`|
| name    | Cannot be blank           | `"Name cannot be blank"`       |

---

## 📜 License

This project is licensed under the MIT License.

---

## ⭐ Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss your ideas.

---

> 💡 *If you like this project, star ⭐ it on GitHub!*


