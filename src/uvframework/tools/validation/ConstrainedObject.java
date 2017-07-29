package uvframework.tools.validation;

import java.beans.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael Maldonado
 */
public class ConstrainedObject {
    private final VetoableChangeSupport vetoableSupport = new VetoableChangeSupport(this);

    public ConstrainedObject() {
      vetoableSupport.addVetoableChangeListener(new Validator());
    }

    protected void validate(String propertyName, int oldValue, int newValue) throws PropertyVetoException {
      vetoableSupport.fireVetoableChange(propertyName, new Integer(oldValue), new Integer(newValue));
    }
    
    protected void validate(String propertyName, String oldValue, String newValue) throws PropertyVetoException {
      vetoableSupport.fireVetoableChange(propertyName, oldValue, newValue);
    }
}
