package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
//    private static String dbURL = "jdbc:postgresql://localhost:5432/university_structure";
//    private static String dbUsername = "postgres";
//    private static String dbPassword = " ";
    public static Connection getConnection(){
        String dbURL = null;
        String dbUsername = null;
        String dbPassword = null;

        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream("jdbc/src/main/resources/config.properties");
            properties.load(fis);

            dbURL = properties.getProperty("db.host");
            dbUsername = properties.getProperty("db.username");
            dbPassword = properties.getProperty("db.password");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return connection;
    }
}
