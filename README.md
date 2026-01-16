# 🎫 Support API

API REST moderna para gestión de tickets de soporte, desarrollada con Java 21 y Spring Boot 3.

## 🚀 Tecnologías

- **Java 21** (LTS)
- **Spring Boot 3.2.1**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Swagger/OpenAPI**
- **Maven**

## 📋 Funcionalidades

- ✅ Crear tickets de soporte
- ✅ Listar tickets con paginación
- ✅ Filtrar por estado (OPEN, IN_PROGRESS, CLOSED)
- ✅ Asignar tickets a agentes
- ✅ Agregar comentarios a tickets
- ✅ Validaciones completas
- ✅ Documentación interactiva con Swagger

## 🔧 Configuración

### Requisitos previos
- Java 21
- PostgreSQL
- Maven

### Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/TU_USUARIO/ticket-support-api.git
cd ticket-support-api
```

2. Crear la base de datos:
```sql
CREATE DATABASE ticket_support_db;
```

3. Configurar credenciales en `application.properties`

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

## 📚 Documentación API

Una vez iniciada la aplicación, accedé a:
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs:** http://localhost:8080/api-docs

## 🏗️ Estructura del Proyecto
```
src/main/java/com/portfolio/ticketsupport/
├── model/          # Entidades JPA
├── repository/     # Repositorios de datos
├── service/        # Lógica de negocio
├── controller/     # Endpoints REST
├── dto/            # Data Transfer Objects
├── exception/      # Manejo de excepciones
└── config/         # Configuraciones
```

## 👨‍💻 Autor

**Germán Orellano** - [LinkedIn](www.linkedin.com/in/germanorellano) - [Portfolio](https://www.gorellanodev.com/)

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.
