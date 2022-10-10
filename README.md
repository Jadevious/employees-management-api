# Kainos Recruitment API Maven repo
This is the repository containing the Maven/Java Dropwizard project that makes up the Kainos Recruitment application's API.

---

### Creating the database properties
Create a db.properties file (`src/main/resources/db.properties`), with `user`, `password`, `host`, `db` properties filled out

### Installing and Building the application
You can install and build the maven project by running the following command.

    $ mvn clean install

### Starting the application
You can start the application by running the following command.

    $ java -jar target/kainos-recruitment-api-1.0-SNAPSHOT-sources.jar server config.yml


To check that your application is running enter url `http://localhost:8080`

### Testing the application
You can run the tests contained in the project simply by running the following command.

    $ mvn clean test

