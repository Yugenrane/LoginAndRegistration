# 🛡️ Spring Security Login & Registration API

## Overview
A complete user authentication and registration system with RESTful endpoints and MySQL integration.

## Features
✅ User registration with encrypted passwords (BCrypt)  
✅ Secure login with JWT authentication  
✅ Role-based access control  
✅ RESTful API endpoints for authentication  
✅ Spring Boot, Spring Security, and JPA integration  

---

## 🏗️ Project Structure (Key Components)
```
src/
├── main/
│   ├── java/com/example/security/
│   │   ├── config/
│   │   │   ├── AppSecurityConfig.java
│   │   ├── controllers/
│   │   │   ├── AuthController.java
│   │   │   ├── UserController.java
│   │   ├── entities/
│   │   │   ├── User.java
│   │   │   ├── Role.java
│   │   ├── repositories/
│   │   │   ├── UserRepository.java
│   │   │   ├── RoleRepository.java
│   │   ├── services/
│   │   │   ├── AuthService.java
│   │   │   ├── UserService.java
│   │   ├── dto/
│   │   │   ├── UserDTO.java
│   │   │   ├── LoginDTO.java
```

---

## 🚀 Core Endpoints
| Endpoint | Method | Request | Response | Description |
|----------|--------|---------|----------|-------------|
| `/api/auth/register` | **POST** | `UserDTO` | `Success Message` | Register a new user |
| `/api/auth/login` | **POST** | `LoginDTO` | `JWT Token` | Authenticate a user |
| `/api/users/me` | **GET** | `JWT Token` | `User Details` | Get logged-in user details |
| `/api/admin/users` | **GET** | `JWT Token (Admin)` | `List of Users` | Get all registered users |

---

## 🔧 Service Layer
Key services include:
- User authentication and authorization
- Password encryption using **BCrypt**
- Token-based authentication using **JWT**

---

## ⚙️ Tech Stack
- **Backend**: Spring Boot 3.4.4 + Spring Security + JPA
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Token)

---

## 🛠️ Setup
1. **Configure MySQL** in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/security_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

2. **Start the application**:
```bash
mvn spring-boot:run
```

---

## 📄 License
MIT © 2024

