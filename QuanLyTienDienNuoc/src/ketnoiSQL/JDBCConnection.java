/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoiSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class JDBCConnection {

    public static Connection getJDBCConnection() {
<<<<<<< HEAD
        final String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyTienDienNuoc;";
        final String user = "mien";
        final String password = "12345";
=======
        
        final String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyTienDienNuoc;";
        
>>>>>>> 8e90b9647e24578d1282951cbdb7ac3da12822bf
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }

}
