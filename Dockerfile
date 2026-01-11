FROM eclipse-temurin:17-jdk

# Create logs directory inside container
RUN mkdir -p /logs && chmod 777 /logs

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]



