/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Huda
 */
public class DatabaseProject {

    /**
     * @param args the command line arguments
     */
    public static Connection get_connection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
        if (conn == null) {
            System.out.println("Unable to connect with database");
            return null;
        }
        System.out.println("Connected with database.");
        return conn;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new homePage2().setVisible(true);
    }
}
