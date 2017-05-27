/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uvframework.tools.WindowsManager;

/**
 *
 * @author Rafael Maldonado
 */
public class UVF extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        WindowsManager.getStage("/login").show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
