FROM openjdk:11
WORKDIR /GTSTimeZonesService
ENV PORT 4703
EXPOSE 4703
COPY target/GTSTimeZonesService-0.0.1-SNAPSHOT.jar /GTSTimeZonesService/
CMD ["java", "-jar", "GTSTimeZonesService-0.0.1-SNAPSHOT.jar"]