# Order Management System

## Project Overview

This is an in-memory Spring Boot application for managing orders, customers, contracts, products, and related entities. The project was developed for the university project assignment.

**Technologies used:**
- Java 17
- Spring Boot
- Maven

## Structure and Layering

**Project follows a clean MVC structure:**
- **Model:** Domain entities (`Customer`, `Order`, `Contract`, etc.)
- **Repository:** Manages in-memory storage (`Map`, `List`)
- **Service:** Business logic, per-entity
- **Controller:** REST API endpoints

**Folder layout:**



## Special Features

- All data is stored in-memory (no database yet).
- Each entity has its own repository, service, and controller.
- 3 model classes expanded with a total of 12 new fields (see source code).
- Code follows SOLID principles, single responsibility per class/layer.
- Endpoints for CRUD: GET/POST/DELETE tested via Postman/curl.

## How to Run

1. Install Java 17+ and Maven.
2. Clone or download this repository.
3. In the project root, run:


4. Test API endpoints on [localhost:8080](http://localhost:8080)

## API Endpoints

| Entity         | List All           | Get by ID            | Add             | Delete                |
|:-------------- |:------------------|:---------------------|:----------------|:----------------------|
| Customer       | `/customers`      | `/customers/{id}`    | POST `/customers` | DELETE `/customers/{id}` |
| Order          | `/orders`         | `/orders/{id}`       | POST `/orders`    | DELETE `/orders/{id}`     |
| Contract       | `/contracts`      | `/contracts/{id}`    | POST `/contracts` | DELETE `/contracts/{id}`  |
| Product        | `/products`       | `/products/{id}`     | POST `/products`  | DELETE `/products/{id}`   |
| ServiceItem    | `/serviceitems`   | `/serviceitems/{id}` | POST `/serviceitems` | DELETE `/serviceitems/{id}` |
| ContractType   | `/contracttypes`  | `/contracttypes/{id}`| POST `/contracttypes` | DELETE `/contracttypes/{id}` |
| ...            | ...               | ...                  | ...                | ...                   |

## Team

- [Your Name]
- [Partner Name]

## Decisions & Justification

- Used clean layered architecture for scalability and maintainability.
- OOP and SOLID principles enforced.
- Data relationships mirror the UML assignment.
- No database used for phase 1 to focus on structure and in-memory logic.

## How to Test

- Use browser (GET requests) or Postman/curl (use POST/DELETE, set body type to JSON).
- See controllers for all endpoints.

## Notes

- Project is self-contained, no external data sources.
- Ready for extension towards DB-backed storage for phase 2.
