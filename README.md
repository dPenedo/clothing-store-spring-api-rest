### Realizar una API RestFul

Deben respetarse las siguientes condiciones:

1. Individual
2. Responder adecuadamente al pedido del Agile Delivery Manager
3. Persistencia de datos en MySQL empleando JPA en tu programa Spring con un CRUD completo
4. Demostrar testeo con Postman y su correcta persistencia en SQL.
5. Consumir una API externa (opcional).

Se valorará:
a) Buenas prácticas en el código.
b) Duración de la presentación HASTA 15': también puede exponer problemas a los que se enfrentó codeando, sus soluciones, y por qué el cliente debería escoger este proyecto y no otro.
c) Correcto funcionamiento de todos sus métodos.
d) Extras para alcanzar la nota máxima: implementación de principios SOLID, agregar mejoras para el cliente, presentación atractiva, completa, repasando cada punto de lo solicitado y gran demostración de conceptos teóricos, diagrama UML.

### Consigna

- Tienda de ropa
- Persistencia de datos
- Objetivo: Diseñar una muestra de funcionamiento de una API RESTful para gestionar productos.

- Los productos tienen: **id, nombre, stock, precio**.
- Se deben gestionar las siguientes **operaciones**: **listar productos con sus cantidades en stock; buscar productos por id; modificar productos; eliminar productos**.
- Ruta administrador = costo normal
- Ruta cliente = costo + 50%
- Utilizar Spring Boot y JPA para la implementación.
- Proporcionar especificaciones claras de las endpoints, distinguiendo una ruta para el comerciante y otra para los clientes (a quien sólo se muestran los precios de consumidor final, no pueden modificar, agregar ni eliminar productos).

### Notas

En el admin ya se pueden hacer las operaciones http básicas y se puede buscar por id.

