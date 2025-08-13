# Transaction Service

A reactive Spring Boot application with modular architecture and Flyway database migration, containerized using Docker.

This service is built using **Java 21**, **Spring WebFlux**, **R2DBC (Reactive Database Access)**, and **Flyway** for database migrations.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Environment Variables](#environment-variables)
- [Docker Setup](#docker-setup)
- [Running Locally](#running-locally)
- [Manual Migration](#manual-migration)

---

## Project Structure
```angular2html
.
├── Dockerfile
├── docker-compose.yml
├── .env
├── migration
│ └── pom.xml
│ └── sql/
├── rest-web
│ └── src/
│ └── pom.xml
├── rest-web-model
├── service-api
├── service-impl
├── dao
├── entity
└── entrypoint.sh
```


**Modules:**

- `migration` – Flyway migrations
- `rest-web` – REST API module
- `rest-web-model` – DTO and model layer
- `service-api` / `service-impl` – Service interfaces and implementations
- `dao` / `entity` – Database layer with R2DBC reactive repositories

---

## Prerequisites

- Docker & Docker Compose
- Java 21 (for local build without Docker)
- Maven 3.9+ (for local build without Docker)

---

## Environment Variables

Create a `.env` file in the project root:

```dotenv
# Spring Reactive Config
SPRING_APPLICATION_NAME=transaction-rest-web
SPRING_R2DBC_URL=r2dbc:mysql://db:3306/transaction_db
SPRING_R2DBC_USERNAME=root
SPRING_R2DBC_PASSWORD=P@ssw0rd

# Flyway Config
FLYWAY_URL=jdbc:mysql://db:3306/transaction_db?useSSL=false&serverTimezone=UTC
FLYWAY_USER=root
FLYWAY_PASSWORD=P@ssw0rd

# MySQL Config
MYSQL_DATABASE=transaction_db
MYSQL_PASSWORD=P@ssw0rd
DB_HOST=db
```
> Note: We use DB_HOST=db to let the app container communicate with the MySQL container in Docker Compose.

---

## Running Locally
### 1. Build and run containers
```bash
docker compose up --build
```
### 2. Access REST API
- Default exposed port: http://localhost:3000
> Note: The MySQL container is exposed on host port 3313 to avoid conflicts with local MySQL.
> 

---

## Manual Migration
```bash
docker compose run --rm migrate
```

Once migration completes, exit container and the REST service can start normally:
```bash
docker compose up app
```

----
## Notes
- Reactive Spring: The application uses WebFlux + R2DBC to handle non-blocking reactive streams. 
- Modular Design: Services, DAO, and entity modules are separated to support clean architecture.
- Docker Multi-Stage: Maven is used only in the build stage. Runtime container is lightweight with only jdk and the packaged jar.