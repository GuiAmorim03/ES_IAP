FROM maven:3.8.5-openjdk-17

WORKDIR /to-do-list

COPY . .

EXPOSE 8080

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run