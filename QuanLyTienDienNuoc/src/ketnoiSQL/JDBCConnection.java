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
        
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            return DriverManager.getConnection("jdbc:jtds:sqlserver://DESKTOP-OIQ8EAC:1433/QuanLyTienDienNuoc");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
