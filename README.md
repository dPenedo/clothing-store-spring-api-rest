# RESTful API built with Spring

This is a practical project developed for the Spring Diploma course at the **Universidad Tecnológica Nacional (UTN), Argentina**.  
It consists of a RESTful API with data persistence in **MySQL**, using **Spring Boot**, **JPA**, and **Maven**.  
The application implements full **CRUD** operations for products.

Testing is performed with **JUnit** and **Mockito**, including both unit tests (for service classes) and integration tests (for controllers).

## Product Fields

Each product includes the following fields:

- `id`
- `name`
- `productType`
- `stock` — only shown in the client endpoint if the stock is below 10 units
- `costPrice` — hidden in the client endpoint (returned as `null`)
- `salePrice` — calculated automatically as `costPrice + 50%`

## Homepage

Visiting the root path (`"/"`) in the browser displays a simple HTML homepage with links to key API endpoints:

- List all products
- Show a limited number of products
- Get product by ID
- View out-of-stock products
- ...

There are separate routes for **admins** and **clients**.

## Design Pattern

The application uses the **Data Transfer Object (DTO)** pattern to transfer data between components within the **Model-View-Controller (MVC)** architecture.

## Getting Started

To run the application locally:

1. Make sure you have **Java 17+**, **Maven**, and **MySQL** installed.
2. Clone the repository:

```bash
git clone https://github.com/dPenedo/clothing-store-spring-api-rest.git
cd clothing-store-spring-api-rest
```

3. Configure the database settings in `src/main/resources/application.properties`.

4. Build and run the project:

```sh
mvn spring-boot:run
```

5. Access the homepage at: `http://localhost:8080`

