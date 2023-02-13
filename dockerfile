FROM openjdk:11-jdk-slim
COPY . /app
WORKDIR /app
RUN javac GeocodingAPI.java
CMD ["java", "GeocodingAPI"]