/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import uvframework.tools.MySQLConn;
import uvframework.tools.WindowsManager;

/**
 *
 * @author Rafael Maldonado
 */
public class UVF extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        if(MySQLConn.InitConn()){
            WindowsManager.getStage("/login").show();
        }else{
            JOptionPane.showMessageDialog(null, "Error Conectando a la DB");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
