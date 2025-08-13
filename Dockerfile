# Build stage
FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY migration ./migration
COPY rest-web ./rest-web
COPY rest-web-model ./rest-web-model
COPY service-api ./service-api
COPY service-impl ./service-impl
COPY dao ./dao
COPY entity ./entity

RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

COPY --from=build /app/rest-web/target/rest-web-1.0.0-SNAPSHOT.jar ./app.jar
COPY entrypoint.sh ./entrypoint.sh
RUN chmod +x ./entrypoint.sh

EXPOSE 3000

ENTRYPOINT ["./entrypoint.sh"]
