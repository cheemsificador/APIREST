# Security API Rest

**Autor**: Mancha Minaya Abel Angelo

---

## Tecnologías

Este proyecto utiliza las siguientes tecnologías:

- **Java 17**
- **Spring Boot 3**
- **Spring Security 6**
- **MySQL Workbench 8.0 CE**
- **Postman**

---


**Contraseña para autenticación**: `12345`

---

## Endpoints

A continuación se detallan los endpoints disponibles y los accesos necesarios para cada uno:

| **Método** | **URL**               | **Accesos**                        | **Resultado**                            |
|------------|-----------------------|------------------------------------|------------------------------------------|
| **GET**    | `/api/publico`         | Todos (incluido anónimo)           | `200 OK`                                 |
| **GET**    | `/api/interno`         | Usuarios autenticados (con credenciales) | `200 OK`                             |
| **GET**    | `/api/admin/gestion`   | Solo usuarios con rol `ROLE_ADMIN` | `200 OK` (admin) / `403 Forbidden` (usuario) |

---

## Entregables

1. **`seguridad_db.sql`**: Este archivo contiene la estructura de la base de datos y está ubicado dentro de la raíz del proyecto.
2. **Carpeta de pruebas**: Incluye todas las pruebas realizadas, incluyendo los casos de uso en Postman.

---

## Pruebas de Postman

A continuación se describen las pruebas realizadas con Postman:

- **Usuario admin**:  
  Endpoint: `/api/admin/gestion`  
  Resultado esperado: `200 OK`

- **Usuario empleado**:  
  Endpoint: `/api/admin/gestion`  
  Resultado esperado: `403 Forbidden`

- **Con credenciales válidas**:  
  Endpoint: `/api/interno`  
  Resultado esperado: `200 OK`

- **Sin credenciales**:  
  Endpoint: `/api/interno`  
  Resultado esperado: `401 Unauthorized`

---

¡Gracias por usar este proyecto!
