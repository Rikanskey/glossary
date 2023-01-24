FROM openjdk:18.0.2.1-jdk

WORKDIR /glossary

COPY .mvn ./.mvn
COPY src ./src
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

RUN ./mvnw package
CMD java -jar target/glossary-0.0.1-SNAPSHOT.jar

EXPOSE 8080