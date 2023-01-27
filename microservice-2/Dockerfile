FROM eclipse-temurin:17.0.5_8-jre-alpine
RUN mkdir /app
WORKDIR /app
COPY build/libs/microservice-2-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]

