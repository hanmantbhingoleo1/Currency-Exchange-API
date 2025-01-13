
# Currency Exchange and Discount Calculation API

## Introduction
This Spring Boot application calculates the payable amount for a bill in a specified currency after applying applicable discounts and converting the currency.

## Features
- Integration with third-party currency exchange API.
- Discount calculation based on user type and bill details.
- Currency conversion from one currency to another.
- Exposed `/api/calculate` endpoint for bill calculation.

## Technologies
Spring Boot: Framework for creating stand-alone Java applications.
Spring Security: Provides authentication and authorization for API endpoints.
Spring Web (RestTemplate): Makes HTTP requests to a third-party service for currency exchange rates.
Logback: Provides logging capabilities.
Maven: Dependency management and build automation.
Code Quality: Integrated with SonarQube for code analysis and Checkstyle for code standard compliance.
Secure /api/calculate endpoint (HTTP Basic Authentication).

## Installation
Prerequisites
JDK 17 or higher
Maven (for building the project)
IDE: (e.g., Spring Tool Suite, IntelliJ IDEA, Eclipse)

## How to Run
1. Clone the repository.
2. Run the application using `mvn spring-boot:run`.
3. Send a POST request to `/api/calculate` with the bill details in JSON format.

### Example Request:
POST /api/calculate
example: http://localhost:8080/api/calculate
```json
request:
{
  "totalAmount": 300.0,
  "groceryAmount": 50.0,
  "userType": "employee",
  "customerTenure": 3,
  "originalCurrency": "USD",
  "targetCurrency": "EUR"
}
response:
{
    "totalAmount": 300.0,
    "groceryAmount": 50.0,
    "userType": "employee",
    "customerTenure": 3,
    "originalCurrency": "USD",
    "targetCurrency": "EUR",
    "discountAmount": 90.0,
    "amountAfterDiscount": 210.0,
    "exchangeRate": 0.975867,
    "finalPayableAmount": 204.93207
}
