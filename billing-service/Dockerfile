FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the generated JAR file into the container
COPY target/billing-service-0.0.1-SNAPSHOT.jar app.jar

# Expose REST Port
EXPOSE 4001

# Expose gRPC Port
EXPOSE 9091

ENTRYPOINT ["java","-jar","app.jar"]