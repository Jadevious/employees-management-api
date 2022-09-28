# name

How to start the name application
---

1. Create a db.properties file (`src/main/resources/db.properties`), with `user`, `password`, `host`, `db` properties filled out
2. Run `mvn clean install` to build your application
3. Start application with `java -jar target/kainos-recruitment-api-1.0-SNAPSHOT.jar server config.yml`
4. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
