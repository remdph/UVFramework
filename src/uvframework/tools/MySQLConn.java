/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Maldonado
 */
public class MySQLConn {
    
    public static Connection conn;
    
    public static Boolean InitConn(){
    
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistema", "root", "r3344t89");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
}
