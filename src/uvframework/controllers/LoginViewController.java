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
import javafx.scene.control.TextField;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;

/**
 *
 * @author Rafael Maldonado
 */
public class LoginViewController implements Initializable {
    
    @FXML private TextField User;
    @FXML private TextField Password;
    
    @FXML   
    private void LoginBtnClick() {
                
        UsuarioEntity user = new UsuarioEntity();
        user.UsrUsr = User.getText();
        user.UsrPwd = Password.getText();
        
        UsuarioEntity dbuser = UsuariosModel.Login(user);
        
        if(dbuser != null){
            System.out.println("Usuario Valido!");
            System.out.println("Bienvenido "+dbuser.UsrNom+"!");
        }else{
            System.out.println("Usuario No VALIDO!!!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
