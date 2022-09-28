package com.kainos.ea.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class JobsDb {

    private static Connection conn;

    public static Connection getConnection() {
        String user;
        String password;
        String host;
        String db;

        if ( conn != null ) return conn;

        try {

            FileInputStream propsStream =
                    new FileInputStream("/Users/jade/Academy/teamC/kainos-recruitment-api/src/main/resources/db.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");
            db              = props.getProperty("db");

            if ( user == null || password == null || host == null )
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");


            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/" + db + "?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
