# Foro Hub 🖥️💬

**Foro Hub** es una API REST creada a través de Spring Boot, construida para crear un entorno en el que los usuarios pueden dialogar sobre varios topicos de interés.

## Objetivo 🎯
Crear una API REST con las siguientes características:
1. Validaciones, de acuerdo a reglas de negocio establecidas por el cliente.
2. Implementación, de una base de datos para la persistencia de la información.
3. Servicio de autenticación, para restringir el acceso a los datos.
4. Migracion a la base de datos (MySQL).
5. Operaciones CRUD(CREATE, READ, UPDATE, DELETE)

## Estructura y funciones 📚

- Tópicos
- Cursos
- Respuestas
- Usuarios
- LoginUser

### Tópicos
Permite al usuario crear un tópico, actualizarlo y eliminarlo. Así mismo, el usuario puede listar los tópicos de otros usuarios, y ver un tópico específico.

*Atributos*
- ID
- Autor
- Título
- Mensaje
- Fecha de creación
- Curso
- Estatus

### Cursos
Permite crear un curso, y clasificarlo de acuerdo a las siguientes categorías: Programación, Front End, Back End, Data Science, DevOps, Otro.

*Atributos*
- ID
- Curso
- Categorías

### Respuestas
El usuario puede responder a tópicos creados por otros usuarios.

*Atributos*
- ID
- Mensaje
- Tópico
- Fecha
- Usuario
- Solución

### Usuarios
Permite registrar y eliminar un usuario.

*Atributos*
- ID
- Nombre
- Correo
- Clave

### LoginUser
Permite registrar el username y clave para el acceso al foro.

*Atributos*
- Username
- Clave

## Instalación y configuración ⚙️

1. Descarga el archivo .zip, y abre el proyecto en tu IDE.
2. Coloca tus credenciales de la base de datos en el archivo application.properties. Igualmente, configura la contraseña que utilizarás para la generación del JWT Token.
```
spring.datasource.url=jdbc:mysql://${HOST}/forohub
spring.datasource.username=${USERNAME}
spring.datasource.password=${PASSWORD}

api.security.secret=${JWT_SECRET}
```

3. Crea la tabla con el nombre 'forohub' en tu base de datos.
4. Ejecuta la aplicación.

## Endpoints 📑 

POST	/usuarios	- Registro de usuarios.

POST	/login	- Autenticación de usuarios.

GET	/topicos	- Listar los tópicos.

GET	/topicos/{id}	- Consultar un tópico con sus respuestas.

POST	/topicos	- Crear un nuevo tópico.

PUT	/topicos/{id}	- Actualizar un tópico existente.

DELETE	/topicos/{id}	- Eliminar un tópico (solo el autor).

POST	/respuestas	- Crear una respuesta a un tópico.

DELETE	/respuestas/{id}	- Eliminar una respuesta (solo el autor).


## Instrucciones de uso 🌟
1. Crea un usuario(login) y una clave.
2. Transforma tu clave a formato Bcrypt.
3. Registra en la base de datos tu login y clave con formato Bcrypt dentro de la tabla usuarioslogin.
4. Utiliza una plataforma API de desarrollo (como Postman, Insomnia, etc). Ingresa en formato JSON el login y la clave utilizadas para generar el JWT Token.
5. Usa el token generado para poder realizar las request que desees.

## Tecnologías utilizadas 🛠️
- Java 17 y Spring Boot
- Spring Security
- MySQL
- Flyway
- Spring web
- Lombok
  

   
