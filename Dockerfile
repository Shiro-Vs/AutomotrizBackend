FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Asegurar permisos para mvnw
RUN chmod +x mvnw

# Construir el proyecto
RUN ./mvnw clean package -DskipTests

# Imagen final
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
