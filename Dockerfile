# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

# Copy the Maven wrapper and the pom.xml to cache dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Copy the application files
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Create a smaller runtime image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the built artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
