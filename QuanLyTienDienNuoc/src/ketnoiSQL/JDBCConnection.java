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
        final String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyTienDienNuoc;";
        final String user = "sa";
        final String password = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) {

        JDBCConnection kn = new JDBCConnection();

        try (Connection cnt = kn.getJDBCConnection()) {
            //System.out.println("Kết nối thành công!");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
