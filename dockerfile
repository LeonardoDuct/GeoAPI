FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY . .
RUN javac GeocodingAPI.java
CMD ["java", "GeocodingAPI"]
