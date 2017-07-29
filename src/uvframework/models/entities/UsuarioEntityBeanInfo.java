/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models.entities;

import java.beans.*;
import uvframework.tools.validation.Validator;
import uvframework.tools.validation.ValidatorTypes;

/**
 *
 * @author Rafael Maldonado
 */
public class UsuarioEntityBeanInfo extends SimpleBeanInfo {
    
    Class targetClass = UsuarioEntity.class;
    
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        
        try  {
            PropertyDescriptor UsrUsr = new PropertyDescriptor("UsrUsr", targetClass, "getUsrUsr", "setUsrUsr");
            PropertyDescriptor UsrNom = new PropertyDescriptor("UsrNom", targetClass, "getUsrNom", "setUsrNom");
            PropertyDescriptor UsrPwd = new PropertyDescriptor("UsrPwd", targetClass, "getUsrPwd", "setUsrPwd");
            PropertyDescriptor UsrTel = new PropertyDescriptor("UsrTel", targetClass, "getUsrTel", "setUsrTel");
            PropertyDescriptor UsrEdad = new PropertyDescriptor("UsrEdad", targetClass, "getUsrEdad", "setUsrEdad");
            
            UsrUsr.setValue(Validator.TYPE,ValidatorTypes.STRING);
            UsrUsr.setValue(Validator.MAX_CHAR, 20);
            UsrUsr.setValue(Validator.NO_EMPTY, true);
            
            UsrNom.setValue(Validator.TYPE,ValidatorTypes.STRING);
            UsrNom.setValue(Validator.MAX_CHAR, 80);
            
            UsrPwd.setValue(Validator.TYPE,ValidatorTypes.STRING);
            UsrPwd.setValue(Validator.MAX_CHAR, 60);
            
            UsrTel.setValue(Validator.TYPE,ValidatorTypes.STRING);
            UsrTel.setValue(Validator.MAX_CHAR, 5);
            
            UsrEdad.setValue(Validator.TYPE,ValidatorTypes.INTEGER);
            UsrEdad.setValue(Validator.IS_INTEGER, true);

            PropertyDescriptor[] pds = new PropertyDescriptor[] {UsrUsr,UsrNom,UsrPwd,UsrTel,UsrEdad};
            
            return pds;

        } catch(IntrospectionException ex) {
            ex.printStackTrace();
            return null;
        }    
    }
}
