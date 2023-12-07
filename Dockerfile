# Stage 1: Dependency download
FROM gradle:jdk21-alpine AS dependencies

WORKDIR /app

COPY build.gradle.kts .
COPY settings.gradle.kts .

# Download and cache the Gradle dependencies
COPY gradle gradle

# Download dependencies
RUN gradle --no-daemon dependencies

# Stage 2: Build the Project
FROM dependencies AS build

WORKDIR /app

# Copy the Gradle files and the source code
COPY --from=dependencies /app .

# Copy the rest of the source code
COPY src src

# Build the project
RUN gradle --no-daemon build

# Stage 2: Build and run
FROM build AS run

ENV POSTGRES_HOST postegres
ENV REDIS_HOST redis

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["gradle", "bootRun"]
