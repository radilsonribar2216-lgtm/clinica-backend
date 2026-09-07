# Backend Clínica Veterinaria — Primer Parcial

Proyecto realizado para la materia de Programación Web (NRC 83862).

El proyecto está desarrollado con **Spring Boot y Maven** y trabaja con la base de datos `clinica`.

## 1. Base de datos

La copia de la base de datos se encuentra en:

`database/clinica_backup.sql`

Para restaurarla en MySQL Workbench:

1. Abrir MySQL Workbench y conectarse al servidor local.
2. Crear la base de datos si todavía no existe:

```sql
CREATE DATABASE clinica CHARACTER SET utf8mb4;
```

3. Ir a **Server > Data Import**.
4. Seleccionar **Import from Self-Contained File**.
5. Seleccionar el archivo `database/clinica_backup.sql`.
6. Elegir la base de datos `clinica`.
7. Iniciar la importación.

La base de datos contiene las tablas necesarias para el funcionamiento del proyecto.

## 2. Configuración

En el archivo:

`src/main/resources/application.properties`

se debe colocar el usuario y contraseña de MySQL local.

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

La opción `spring.jpa.hibernate.ddl-auto=none` se mantiene porque las tablas ya están creadas en la base de datos.

## 3. Ejecutar el proyecto

Abrir la carpeta del proyecto desde **IntelliJ IDEA**.

El proyecto utiliza Maven, por lo que IntelliJ descargará las dependencias necesarias.

Se puede ejecutar desde la clase:

`ClinicaApplication`

o desde la terminal:

```bash
mvn spring-boot:run
```

El backend se ejecuta en:

`http://localhost:8080`

## 4. Endpoints principales

| Método | Endpoint                | Función                             |
| ------ | ----------------------- | ----------------------------------- |
| GET    | `/api/formulas`         | Consultar fórmulas médicas          |
| GET    | `/api/citas`            | Consultar citas por rango de fechas |
| POST   | `/api/citas`            | Crear una cita                      |
| PUT    | `/api/citas/{id}`       | Actualizar una cita                 |
| POST   | `/api/historias`        | Crear una historia médica           |
| GET    | `/api/historias`        | Consultar historias                 |
| GET    | `/api/historias/{id}`   | Consultar una historia              |
| PUT    | `/api/historias/{id}`   | Actualizar una historia             |
| DELETE | `/api/historias/{id}`   | Eliminar una historia               |
| POST   | `/api/anotaciones`      | Crear una anotación                 |
| GET    | `/api/anotaciones`      | Consultar anotaciones por fecha     |
| PUT    | `/api/anotaciones/{id}` | Actualizar una anotación            |

## 5. Ejemplo para crear una cita

```json
{
  "clienteId": 1,
  "mascotaId": 1,
  "medicoId": 3,
  "fechaHora": "2026-09-20T10:30:00",
  "estado": "programada",
  "motivo": "Control de vacunas"
}
```

## 6. Estructura del proyecto

```text
src/main/java/com/uniminuto/clinica/
├── ClinicaApplication.java
├── controller/
├── service/
│   └── impl/
├── repository/
├── model/
├── dto/
└── exception/
```

Las carpetas principales se utilizan para separar los controladores, servicios, repositorios, modelos, DTO y manejo de excepciones.

## 7. Compilación

Para generar el proyecto compilado:

```bash
mvn clean package
```

Esto genera los archivos de compilación dentro de la carpeta `target/`.

Para la entrega se debe comprimir el proyecto según las indicaciones del docente y subir el `.zip` al aula virtual.

## 8. Git

La rama utilizada para el proyecto es:

`codigo_radilson_rivaldo`

El proyecto también se encuentra en GitHub.
