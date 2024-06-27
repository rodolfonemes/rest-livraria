FROM maven:3.8.6-eclipse-temurin-11 AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests


FROM eclipse-temurin:11-jdk
RUN mkdir /app
COPY --from=build /project/target/Livraria-0.0.1-SNAPSHOT.jar /app/Livraria-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "Livraria-0.0.1-SNAPSHOT.jar"