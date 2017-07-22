/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.usuarios;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import uvframework.UVF;
import uvframework.models.UsuariosModel;
import uvframework.tools.TableViewAdapter;
import uvframework.tools.TableViewColumn;
import uvframework.tools.TableViewRow;
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
        
        TableViewAdapter tva = new TableViewAdapter(ResultadoTable);
        ArrayList titles = new ArrayList();
        
        titles.add(new TableViewColumn("UsrUsr","Usuario",100.0));
        titles.add(new TableViewColumn("UsrNom","Nombre",200.0));
        titles.add(new TableViewColumn("UsrPwd","Clave",100.0));
        
        //tva.setRowClickHandler((e)->{this.TableRowClick();});
        tva.setRowDoubleClickHandler((e)->{this.TableRowClick();});
        
        tva.fromResultSet(rs, titles);
    }
    
    private void TableRowClick(){

        String UsrUsr = ((TableViewRow) ResultadoTable.getSelectionModel().getSelectedItem()).get("UsrUsr").toString();
        
        UVF.workdata.put("UsrUsr", UsrUsr);
        
        WindowsManager.getStage("/usuarios/editar",true).show();
    }

    @FXML 
    private void NuevoBtnClick(){
        WindowsManager.getStage("/usuarios/nuevo").show();
    }
    
}
