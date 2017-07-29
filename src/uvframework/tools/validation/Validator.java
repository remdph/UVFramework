/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.tools.validation;

import java.beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael Maldonado
 */
public class Validator implements VetoableChangeListener{
    public static final String MAX_CHAR = "MAX_CHAR";
    public static final String IS_INTEGER = "IS_INTEGER";
    public static final String NO_EMPTY = "NO_EMPTY";
    public static final String TYPE = "TYPE";
    
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        try {
            BeanInfo info = Introspector.getBeanInfo(evt.getSource().getClass());
            PropertyDescriptor descriptor = getDescriptor(evt.getPropertyName(), info);
            
            if(descriptor.getValue(TYPE) == ValidatorTypes.STRING){
                
                if(descriptor.getValue(MAX_CHAR) != null){
                    Integer max = (Integer) descriptor.getValue(MAX_CHAR);

                    if(evt.getNewValue().toString().length() > max) {
                        System.out.println("La cadena " + evt.getNewValue() + " no puede ser mayor a " + max + " caracter(es).");
                    }
                }
                
                if(descriptor.getValue(NO_EMPTY) != null){
                    Boolean noempty = (boolean) descriptor.getValue(NO_EMPTY);

                    if(noempty && evt.getNewValue().toString().length() <= 0) {
                        System.out.println("No puede dejar campos en blanco");
                    }
                }
            }
            
            
            if(descriptor.getValue(TYPE) == ValidatorTypes.INTEGER){
                if(descriptor.getValue(IS_INTEGER) != null){
                    Boolean isint = (boolean) descriptor.getValue(IS_INTEGER);

                    if(isint && !Character.isDigit(evt.getNewValue().toString().charAt(0))){
                        System.out.println("El valor no es un entero.");
                    }
                }
            }

        } catch (IntrospectionException ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private PropertyDescriptor getDescriptor(String name, BeanInfo info) throws IllegalArgumentException {
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        for( int i=0; i<pds.length; i++) {
            if( pds[i].getName().equals(name) ) {
              return pds[i];
            }
        }
        throw new IllegalArgumentException("Property " + name + " not found.");
    }
}
