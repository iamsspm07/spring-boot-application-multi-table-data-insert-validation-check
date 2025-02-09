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

## Key Validations

- **Email**: The email must follow the standard email format (e.g., `example@domain.com`). This is validated using the `@Email` annotation.

- **Phone Number**: The phone number must be exactly 10 digits. This is validated using a custom regex pattern:  
  ```regex
  ^\d{10}$
- **Password**: The password must be between 8 and 10 characters long and contain at least one alphanumeric character and one special character. This is validated using the regex: ^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$

## API Endpoints

### 1. **User Registration**

**URL**: `/api/users/register`

**Method**: `POST`

**Request Body**:

```json
{
    "userName": "Sujit Shibaprasad Maity",
    "userMail": "sujitmaity@yahoo.com",
    "userPassword": "P@ssw0rd123",
    "userNumber": "7770053550",
    "userRole": "Customer",
    "userProfession": "Business",
    "country": "India",
    "city": "Mumbai"
}
