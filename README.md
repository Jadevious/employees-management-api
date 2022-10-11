# Kainos Recruitment API Maven repo
This is the repository containing the Maven/Java Dropwizard project that makes up the Kainos Recruitment application's API.

---

### Connecting to the database
You can connect to your mysql server by either by the command line or by mySQLWorkbench.


### Using the terminal
Connect to your MySQL server from the command line using the following command containing your unique host, username and password credentials.

    $ mysql -h `host` -u `user` -p `password`

You can import the given database.sql file found in the github repository by typing:

    $ mysql source /path/to/database.sql;
    

### Using MySQLWorkbench
Launch MySQLWorkbench and click the "+" symbol in the "MySQLConnections" tab to add a new connection. Enter a name for the connection in the "Connection Name" field. 

Select "Standard (TCIP/IP)" as the "Connection Type".

Enter your `host` in the "Hostname" field.

Specify the "Username" as your `user` credential.

Enter your `password` by clicking the Store in Keychain button beside "Password".

Once connected to the database go to Data Import/Restore. Choose the option Import from Self-Contained File and select the database.sql file.


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

