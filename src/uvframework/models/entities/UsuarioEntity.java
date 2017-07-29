/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models.entities;

import java.beans.PropertyVetoException;
import uvframework.tools.validation.ConstrainedObject;

/**
 *
 * @author Rafael Maldonado
 */
public class UsuarioEntity extends ConstrainedObject {
    
    public String UsrUsr;
    public String UsrNom;
    public String UsrPwd;
    public String UsrTel;
    public String UsrEdad;
    
    public void setUsrUsr(String newUsrUsr) throws PropertyVetoException{
        validate("UsrUsr", UsrUsr, newUsrUsr);
        UsrUsr = newUsrUsr;
    }
    
    public void setUsrNom(String newUsrNom) throws PropertyVetoException{
        validate("UsrNom", UsrNom, newUsrNom);
        UsrNom = newUsrNom;
    }
    
    public void setUsrPwd(String newUsrPwd) throws PropertyVetoException{
        validate("UsrPwd", UsrPwd, newUsrPwd);
        UsrPwd = newUsrPwd;
    }
    
    public void setUsrTel(String newUsrTel) throws PropertyVetoException{
        validate("UsrTel", UsrTel, newUsrTel);
        UsrTel = newUsrTel;
    }
    
    public void setUsrEdad(String newUsrEdad) throws PropertyVetoException{
        validate("UsrEdad", UsrEdad, newUsrEdad);
        UsrEdad = newUsrEdad;
    }
    
    public String getUsrUsr(){
        return UsrUsr;
    }
    
    public String getUsrNom(){
        return UsrNom;
    }
    
    public String getUsrPwd(){
        return UsrPwd;
    }
    
    public String getUsrTel(){
        return UsrTel;
    }
    
    public String getUsrEdad(){
        return UsrEdad;
    }
    
}
