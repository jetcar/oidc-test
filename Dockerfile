# syntax=docker/dockerfile:1
# Dockerfile for oidc-test project - Single stage with JDK for debugging
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy only pom.xml first to leverage Docker cache for dependencies
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B || true

# Copy source code
COPY src ./src

# Build the application
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests && \
    mv target/oidc-test-0.0.1-SNAPSHOT.jar app.jar && \
    rm -rf target src

EXPOSE 8082 5006
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
