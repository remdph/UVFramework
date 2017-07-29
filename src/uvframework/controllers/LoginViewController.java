/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import uvframework.UVF;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;
import uvframework.tools.WindowsManager;

/**
 *
 * @author Rafael Maldonado
 */
public class LoginViewController implements Initializable {
    
    @FXML private TextField UsrUsr;
    @FXML private TextField UsrPwd;
    @FXML private TextField UsrTel;
    @FXML private TextField UsrEdad;
    
    @FXML   
    private void LoginBtnClick() throws PropertyVetoException {
                
        UsuarioEntity user = new UsuarioEntity();
        user.setUsrUsr(UsrUsr.getText());
        user.setUsrPwd(UsrPwd.getText());
        user.setUsrTel(UsrTel.getText());
        user.setUsrEdad(UsrEdad.getText());
        
        UsuarioEntity dbuser = UsuariosModel.Login(user);
        
        if(dbuser != null){
            System.out.println("Usuario Valido!");
            System.out.println("Bienvenido "+dbuser.UsrNom+"!");
            UVF.user = dbuser;
            WindowsManager.getStage("/login").hide();
            WindowsManager.getStage("/main").show();
        }else{
            System.out.println("Datos Incorrectos");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
