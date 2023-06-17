FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY /target/Discovery-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8761
CMD ["java", "-jar", "/opt/app/Discovery-0.0.1-SNAPSHOT.jar"]
