# Kainos Recruitment API Maven repo
This is the repository containing the Maven/Java Dropwizard project that makes up the Kainos Recruitment application's API.

---

### Connecting to the database
You can connect to your mysql server by either by the command line or by mySQLWorkbench.


### Using the terminal
Connect to your MySQL server from the command line using the following command containing your unique host, username and password credentials.

    $ mysql -h `host` -u `user` -p `password`

Create an empty database and use it. You then can import the given database.sql file found in the github repository by running:

    $ mysql source /path/to/database.sql;
    

### Using MySQLWorkbench
Launch MySQLWorkbench and click the "+" symbol in the "MySQLConnections" tab to add a new connection. Enter a name for the connection in the "Connection Name" field. 

Select "Standard (TCIP/IP)" as the "Connection Type".

Enter your `host` in the "Hostname" field.

Specify the "Username" as your `user` credential.

Enter your `password` by clicking the Store in Keychain button beside "Password".

Once connected to the database go to Data Import/Restore. Choose the option Import from Self-Contained File and select the database.sql file.


### Building and running the project
There are two ways to approach project setup and execution - Either directly (as follows) or building a docker image.

#### Building and running the project in the terminal
Before anything, you'll want to set an environmental variables for the properties of your aforementioned database.

    $ export DB_USERNAME=<Your database username>
    $ export DB_PASSWORD=<Your database password>
    $ export DB_HOST=<Your database URL/ip>
    $ export DB_NAME=<Your database schema name>

You can install and build the maven project by running the following command.

    $ mvn clean install

You can then start the application by running the following command.

    $ java -jar target/kainos-recruitment-api-1.0-SNAPSHOT.jar server config.yml

#### Building and running the project in a docker container
The project has been pre-prepared for containerisation with an included dockerfile.

First, you should build the latest version of your project in docker, citing your database's credentials.
    
    $ docker build -t kainos-recruitment-api --build-arg DB_USERNAME=<Your database username> 
    --build-arg DB_PASSWORD=<Your database password> 
    --build-arg DB_HOST=<Your database URL/ip>
    --build-arg DB_NAME=<Your database schema name> ./

Following the build, you should be able to run the docker image instantly, in this case exposing the 8080 port for the project
    
    docker run -p 8080:8080 kainos-recruitment-api


### Testing the application
To check that your application is running, you can enter url `<Your URL>:8080/api/job-roles`

You can run the unit tests contained in the project simply by running the following command.

    $ mvn clean test

You can also run all tests contained in the project (integration tests included) simply by running the following command.

    $ mvn clean integration-test
