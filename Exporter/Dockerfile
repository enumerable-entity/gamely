FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY /target/Exporter-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8087
CMD ["java", "-jar", "/opt/app/Exporter-0.0.1-SNAPSHOT.jar"]
