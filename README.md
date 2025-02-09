# Spring Boot User Registration Application

This is a Spring Boot application for handling user registration, including validations for mobile number, email, and password. It provides an API to register users while ensuring that the required fields are properly validated.

## Features
- **User Registration**: A REST API endpoint for registering a new user.
- **Field Validations**:
  - **Mobile Number**: Must be exactly 10 digits.
  - **Email**: Must follow a valid email format.
  - **Password**: Must be between 8-10 characters long and contain at least one alphanumeric character and one special symbol.
- **User Roles and Professions**: Supports predefined roles (`Customer`, `Seller`, `Admin`, etc.) and professions (`Student`, `Business`, etc.).
- **Exception Handling**: Global exception handler for validation and other errors.

## Tech Stack
- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Validation**: Java Bean Validation (JSR-303)
- **Security**: Spring Security for password encoding
- **Dependencies**: Spring Web, Spring Data JPA, Spring Boot Starter Validation

## Project Structure

spring-boot-user-registration
│
├── src
│   └── main
│       ├── java
│       │   └── genaicorecorp
│       │       └── com
│       │           ├── controller
│       │           │   └── UserController.java       # Controller for user registration and handling requests
│       │           ├── dto
│       │           │   └── UserDTO.java              # Data Transfer Object for user data
│       │           ├── entity
│       │           │   ├── Registration.java         # Entity for registration table
│       │           │   ├── UserMaster.java           # Entity for user master table
│       │           │   ├── RegistrationLog.java      # Entity for registration log table
│       │           │   ├── UserRole.java             # Entity for user role table
│       │           │   └── UserProfession.java       # Entity for user profession table
│       │           ├── repository
│       │           │   ├── RegistrationRepository.java      # Repository for Registration entity
│       │           │   ├── UserMasterRepository.java        # Repository for UserMaster entity
│       │           │   ├── RegistrationLogRepository.java   # Repository for RegistrationLog entity
│       │           │   ├── UserRoleRepository.java          # Repository for UserRole entity
│       │           │   └── UserProfessionRepository.java    # Repository for UserProfession entity
│       │           ├── service
│       │           │   └── RegistrationService.java      # Service class for user registration logic
│       │           └── exception
│       │               └── GlobalExceptionHandler.java   # Global exception handler for centralized exception handling
│       │
│       ├── resources
│       │   ├── application.properties                 # Spring Boot application configurations
│       │   └── static
│       │       └── ...                                # Static resources (e.g., CSS, JS) if needed
│       │   └── templates
│       │       └── ...                                # HTML templates if you are using Thymeleaf
│
├── pom.xml                                            # Maven Project Object Model (POM) file for dependencies and build configuration
└── README.md                                          # Project documentation (optional but recommended)
