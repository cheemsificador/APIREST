Security Api Rest

Mancha Minaya Abel Angelo

Tecnologias

•	java 17
•	Spring Boot 3
•	Spring Security 6
•	MySQL Workbench 8.0 CE
•	Postman

"Contraseña: 12345"

Endpoints
Metodo	URL	Accesos	Resultado
GET	/api/publico		Todos (incluido anonimo	200 OK
GET	/api/interno		Usuarios autenticados	200 OK(teniendo credenciales)
GET	/api/admin/gestion	Solo ROLE_ADMIN	200 OK admin / 403 usuario



Emtregables
seguridad_db.sql = dentro de la raiz del proyecto
Entregables = (carpeta con todas las pruebas)

Pruebas de Postman
Usuario admin 
/api/admin/gestion → 200 OK

Usuario empleado 
/api/admin/gestion → 403 Forbidden

Con credenciales 
/api/interno → 200 OK

Sin credenciales 
/api/interno → 401 Unauthorized
