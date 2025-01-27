FROM openjdk:11
WORKDIR /Timezone-Service
ENV PORT 4703
EXPOSE 4703
COPY target/GTSTimeZonesService-0.0.1-SNAPSHOT.jar /Timezone-Service/
CMD ["java", "-jar", "GTSTimeZonesService-0.0.1-SNAPSHOT.jar"]
