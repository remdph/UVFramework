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
import uvframework.UVF;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author Rafael Maldonado
 */
public class UsuariosEditarViewController implements Initializable {

    @FXML private TextField UsrUsr;
    @FXML private TextField UsrNom;
    @FXML private PasswordField UsrPwd;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UsuarioEntity data = UsuariosModel.getOne(UVF.workdata.get("UsrUsr").toString());
        UsrUsr.setText(data.UsrUsr);
        UsrNom.setText(data.UsrNom);
        UsrPwd.setText(data.UsrPwd);
    }    
    
    @FXML
    private void GuardarBtnClick(){
        UsuarioEntity user = new UsuarioEntity();
        
        user.UsrNom = UsrNom.getText();
        user.UsrPwd = UsrPwd.getText();
        user.UsrUsr = UsrUsr.getText();
        
        if(UsuariosModel.Editar(user)){
            JOptionPane.showMessageDialog(null, "Cambios Guardados");
            WindowsManager.getStage("/usuarios/editar").hide();
        }else{
            JOptionPane.showMessageDialog(null, "Error guardando usuario");
        }
    }
    
    @FXML
    private void CancelarBtnClick(){
    
    }
    
}
