# Dockerfile para el backend de Automotriz
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Dar permisos al mvnw
RUN chmod +x mvnw

# Compilar el proyecto y generar el jar
RUN ./mvnw clean package -DskipTests

# Etapa final: solo copia el .jar generado
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia el .jar desde la fase anterior
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Ejecuta el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
