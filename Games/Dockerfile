FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY /target/Games-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8084
CMD ["java", "-jar", "/opt/app/Games-0.0.1-SNAPSHOT.jar"]
