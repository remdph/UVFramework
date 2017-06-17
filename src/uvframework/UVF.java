/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import uvframework.tools.MySQLConn;
import uvframework.tools.WindowsManager;

/**
 *
 * @author Rafael Maldonado
 */
public class UVF extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        testjson();
    }
//        if(MySQLConn.InitConn()){
  ///          WindowsManager.getStage("/login").show();
     //   }else{
       //     JOptionPane.showMessageDialog(null, "Error Conectando a la DB");
        //}
   // }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void testjson(){
        String sjson = "{ \"nombre\":\"Rafael Maldonado\", \"numeros\":[10,20,30,40,50], \"subobjeto\":{ \"elemento1\":\"Text1\", \"elemento2\":\"Text2\" } }";       
                
        JSONObject job = new JSONObject(sjson);
        
        System.out.println(job.getString("nombre"));
        System.out.println(job.getJSONArray("numeros").getInt(2));
        System.out.println(job.getJSONObject("subobjeto").getString("elemento2"));
        
        
    }
}
