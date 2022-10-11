FROM maven:3.8.6-jdk-11
WORKDIR /publish
COPY ./ /publish
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "target/kainos-recruitment-api-1.0-SNAPSHOT.jar", "server", "config.yml"]