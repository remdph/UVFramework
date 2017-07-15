/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import uvframework.UVF;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author Rafael Maldonado
 */
public class MainViewController implements Initializable {
    
    @FXML private Label UsrNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsrNom.setText(UVF.user.UsrNom);
    }   
    
    @FXML
    private void CerrarMenuClick(){
        WindowsManager.getStage("/login").show();
        WindowsManager.getStage("/main").hide();
    }
    
    @FXML
    private void UsuariosMenuClick(){
        WindowsManager.getStage("/usuarios").show();
    }
    
}
