/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.usuarios;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import uvframework.models.UsuariosModel;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author Rafael Maldonado
 */
public class UsuariosViewController implements Initializable {
    
    @FXML private TableView ResultadoTable; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    @FXML
    private void BuscarBtnClick() throws SQLException{
        ResultSet rs = UsuariosModel.buscar("");
        
        while(rs.next()){
            System.out.print(rs.getObject("UsrUsr").toString());
            System.out.print(" - ");
            System.out.println(rs.getObject("UsrNom").toString());
        }
    }

    @FXML 
    private void NuevoBtnClick(){
        WindowsManager.getStage("/usuarios/nuevo").show();
    }
    
}
