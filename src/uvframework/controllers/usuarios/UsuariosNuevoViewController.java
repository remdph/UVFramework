/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.usuarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author Rafael Maldonado
 */
public class UsuariosNuevoViewController implements Initializable {

    @FXML private TextField UsrUsr;
    @FXML private TextField UsrNom;
    @FXML private PasswordField UsrPwd;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void CrearBtnClick(){
        UsuarioEntity user = new UsuarioEntity();
        
        user.UsrNom = UsrNom.getText();
        user.UsrPwd = UsrPwd.getText();
        user.UsrUsr = UsrUsr.getText();
        
        if(UsuariosModel.Nuevo(user)){
            JOptionPane.showMessageDialog(null, "Usuario Creado");
            WindowsManager.getStage("/usuarios/nuevo").hide();
        }else{
            JOptionPane.showMessageDialog(null, "Error creando usuario");
        }
    }
    
    @FXML
    private void CancelarBtnClick(){
    
    }
    
}
