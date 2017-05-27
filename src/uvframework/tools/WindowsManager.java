/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uvframework.UVF;

/**
 *
 * @author Rafael Maldonado
 */
public class WindowsManager {
    
    private static final Map stages = new HashMap(); 
    
    public static Stage getStage(String path){
        Stage selected = null;
        
        try {
            
            if(!stages.containsKey(path)){
                Parent root = getParentFXML(path);
                selected = new Stage();
                selected.setScene(new Scene(root));
                stages.put(path, selected);                
            }
            
            selected = (Stage) stages.get(path);
            
        } catch (IOException ex) {
            Logger.getLogger(WindowsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return selected;
    }
 
    private static Parent getParentFXML(String path) throws IOException{        
        String fullpath;

        switch(path){
            case "/login": fullpath="views/LoginView.fxml"; break;
            case "/main": fullpath="views/LoginView.fxml"; break;
            case "/usuario/buscar": fullpath="views/LoginView.fxml"; break;
            default: fullpath="views/LoginView.fxml";
        }
        
        return FXMLLoader.load(UVF.class.getResource(fullpath));
    }
}
