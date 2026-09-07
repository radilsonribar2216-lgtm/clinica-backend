# Backend Clínica Veterinaria — Primer Parcial Programación Web (NRC 83862)

Proyecto Spring Boot + Maven que resuelve los 5 requerimientos del parcial sobre la base
de datos `clinica` (formulas médicas, citas, historia médica y anotaciones).

## 1. Restaurar la base de datos en MySQL Workbench

1. Abre **MySQL Workbench** y conéctate a tu servidor local (`root` / tu contraseña).
2. Crea la base de datos (si no existe):
   ```sql
   CREATE DATABASE clinica CHARACTER SET utf8mb4;
   ```
3. Restaura el backup:
   - Menú **Server > Data Import**.
   - Selecciona **Import from Self-Contained File** y elige `database/clinica_backup.sql`
     (incluido en este proyecto).
   - En **Default Target Schema** elige `clinica`.
   - Clic en **Start Import**.
   - Alternativa por consola (cmd/terminal, con `mysql` en el PATH):
     ```bash
     mysql -u root -p clinica < database/clinica_backup.sql
     ```
4. Verifica que las tablas quedaron creadas: `cita`, `cliente`, `especializacion`,
   `formula_medica`, `historia_medica`, `anotacion_historia`, `mascota`, `medicamento`,
   `medico`, `raza`, `session`, `usuario`.

## 2. Configurar la conexión del backend

Abre `src/main/resources/application.properties` y ajusta usuario/contraseña de tu MySQL local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD_AQUI
```

No cambies `spring.jpa.hibernate.ddl-auto=none`: la base ya existe (restaurada del backup),
así que Spring **no** debe intentar crear ni modificar las tablas.

## 3. Abrir y ejecutar el proyecto en IntelliJ IDEA

1. **File > Open** y selecciona la carpeta `clinica-backend` (la que contiene `pom.xml`).
2. IntelliJ detecta que es un proyecto Maven y descarga las dependencias automáticamente
   (ícono del elefante de Maven en la barra lateral derecha si quieres forzar el *reload*).
3. Verifica el JDK del proyecto: **File > Project Structure > Project** → SDK 17 o superior.
4. Ejecuta la clase `ClinicaApplication` (botón ▶ verde) o desde terminal:
   ```bash
   mvn spring-boot:run
   ```
5. El backend queda escuchando en `http://localhost:8080`.

Si prefieres compilar el `.zip` que exige la entrega:
```bash
mvn clean package
```
Esto genera `target/clinica-backend.jar`, listo para comprimir junto al código como pide el enunciado.

## 4. Endpoints disponibles

| # Requerimiento | Método | Endpoint | Descripción |
|---|---|---|---|
| 1 | GET | `/api/formulas` | Lista fórmulas médicas ordenadas por fecha de creación (desc) |
| 2/3 | GET | `/api/citas?fechaInicio=2024-01-01T00:00:00&fechaFin=2025-12-31T23:59:59` | Filtra citas por rango de fecha (desc) |
| 4 | POST | `/api/citas` | Crea una nueva cita |
| 4 | PUT | `/api/citas/{id}` | Actualiza una cita existente |
| 5 | POST | `/api/historias` | Crea una historia médica |
| 5 | GET | `/api/historias` | Lista todas las historias médicas |
| 5 | GET | `/api/historias/{id}` | Consulta una historia médica |
| 5 | PUT | `/api/historias/{id}` | Actualiza una historia médica |
| 5 | DELETE | `/api/historias/{id}` | Elimina una historia médica |
| 5 | POST | `/api/anotaciones` | Crea una anotación de historia médica |
| 5 | GET | `/api/anotaciones?fechaInicio=...&fechaFin=...` | Lista anotaciones por rango de fecha (desc) |
| 5 | PUT | `/api/anotaciones/{id}` | Actualiza una anotación |

### Ejemplo body para crear/actualizar una cita (`POST`/`PUT /api/citas`)
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

### Ejemplo body para crear una anotación (`POST /api/anotaciones`)
```json
{
  "historiaId": 1,
  "medicoId": 3,
  "descripcion": "Paciente presenta buena evolución, se continua tratamiento."
}
```

Puedes probar todo esto con **Postman**, **Insomnia** o la extensión REST Client de IntelliJ.

## 5. Estructura del proyecto (arquitectura Controller/Service/Repository/DTO)

```
src/main/java/com/uniminuto/clinica/
├── ClinicaApplication.java
├── controller/     -> Expone los endpoints REST
├── service/        -> Interfaces con la lógica de negocio
│   └── impl/        -> Implementaciones de los servicios
├── repository/     -> Interfaces JpaRepository (acceso a datos)
├── model/          -> Entidades JPA mapeadas a las tablas de MySQL
├── dto/            -> Objetos de transferencia (entrada/salida de la API)
└── exception/      -> Manejo centralizado de errores (GlobalExceptionHandler)
```

## 6. Flujo de Git pedido en el tutorial SSH

```bash
git checkout -b 83862_TU_NOMBRE     # rama con estructura codigo_nombre
git pull origin desarrollo          # o main, según lo indique el docente
git add .
git commit -m "Solucion primer parcial: formulas, citas e historia medica"
git push origin 83862_TU_NOMBRE
```

Recuerda además subir el `.zip` del código compilado (`mvn clean package` genera el jar en `target/`)
de forma **individual** en el aula virtual.
