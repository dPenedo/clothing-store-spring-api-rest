# RESTful API built with Spring

This is a practical project developed for the Spring Diploma course on the **Universidad Tecnologica Nacional** (UTN-Argentina). It consists of a RESTful API with data persistence in MySQL, using JPA and implementing full CRUD operations for products.

## Product Fields

Each product includes the following fields:

- `id`
- `name`
- `product type`
- `stock` (only shown in the client endpoint if the stock is below 10 units)
- `cost price` (hidden in the client endpoint, shown as `null`)
- `sale price` (calculated as cost price + 50%)

## Homepage

Visiting the root path (`"/"`) in the browser displays a `HTML` simple homepage with links to the main API endpoints:

- Show all products
- Show a limited list of products
- Get product by ID
- Show out-of-stock products
- ...

There are separate routes for **admins** and **clients**.

## Design Pattern

The application uses the **Data Transfer Object (DTO)** pattern to transfer data between the components in the **Model-View-Controller** architecture.