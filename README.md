# **Tennis Score Application**

A Spring Boot-based REST API to compute tennis match scores based on user input. This project follows a clean architecture, with features like input validation, integration tests, and Swagger API documentation.

---

## **Table of Contents**

1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Setup Instructions](#setup-instructions)
4. [API Documentation](#api-documentation)
5. [Testing](#testing)
6. [Project Structure](#project-structure)
7. [License](#license)

---

## **Features**

- Compute tennis match scores based on input strings like `"ABABAA"`.
- Supports both uppercase (`A`, `B`) and lowercase (`a`, `b`) inputs.
- Validation for invalid or empty inputs.
- Comprehensive unit and integration tests.
- Swagger UI for interactive API documentation.

---

## **Technologies Used**

- **Java 21**
- **Spring Boot 3.x**
    - Spring Web
    - Spring Validation
- **JUnit 5** for unit and integration testing
- **Mockito** for mocking dependencies
- **Cucumber** for behavior-driven development (BDD)
- **Lombok** for reducing boilerplate code
- **Swagger/OpenAPI** for API documentation

---

## **Setup Instructions**

### **1. Prerequisites**
- JDK 21 or later
- Maven 3.8+ installed
- A modern IDE like IntelliJ IDEA or Eclipse

### **2. Clone the Repository**
```bash
git clone https://github.com/hamzus1992/tenniscata
cd tennis
```

### **3. Build and Run the Application**
```bash
mvn clean install
mvn spring-boot:run
```

### **4. Access the Application**
- API Base URL: `http://localhost:8080/api/tennis`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## **API Documentation**

### **Endpoint: Compute Tennis Score**

#### **POST** `/api/tennis/compute`

**Request:**
```json
{
  "input": "ABABAA"
}
```

**Response:**
```plaintext
Player A : 15 / Player B : 0
Player A : 15 / Player B : 15
Player A : 30 / Player B : 15
Player A : 30 / Player B : 30
Player A : 40 / Player B : 30
Player A wins the game
```

**Validation Errors:**
If the input is invalid or empty, the API returns a `400 Bad Request` with an appropriate error message:
```json
{
  "input": "Input string can only contain 'A', 'a', 'B', or 'b'"
}
```

---

## **Testing**

The application includes comprehensive tests for controller, service, and integration logic.

### **Run All Tests**
```bash
mvn test
```

### **Run Integration Tests**
```bash
mvn verify
```

---

## **Project Structure**

```plaintext
src/main/java/com/cata/tennis
├── adapter
│   └── TennisMatchController.java      # REST API Controller
├── config
│   └── SwaggerConfig.java                 # Swagger API Configuration
├── domain
│   ├── TennisMatch.java                   # Domain Logic
│   ├── TennisMatchFactory.java            # Factory Logic
│   ├── TennisMatchPort.java               # Interface for Service
│   └── TennisMatchService.java            # Business Logic Implementation
├── dto
│   └── TennisMatchInputDTO.java           # Data Transfer Object with Validation
└── exception
    └── GlobalExceptionHandler.java        # Exception Handling for Validation
```

---


## **Contributors**

- **Hamza RAKROUKI** - [GitHub Profile](https://github.com/your-username)

For any issues or feature requests, feel free to create an issue in the repository.
