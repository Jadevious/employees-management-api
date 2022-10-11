FROM maven:3.8.6-jdk-11

ARG DB_USERNAME
ARG DB_PASSWORD
ARG DB_HOST
ARG DB_NAME

ENV DB_USERNAME ${DB_USERNAME}
ENV DB_PASSWORD ${DB_PASSWORD}
ENV DB_HOST ${DB_HOST}
ENV DB_NAME ${DB_NAME}

WORKDIR /publish
COPY ./ /publish

RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "target/kainos-recruitment-api-1.0-SNAPSHOT.jar", "server", "config.yml"]