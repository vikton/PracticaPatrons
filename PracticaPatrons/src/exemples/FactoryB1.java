/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

import common.DependencyException;
import simple.Factory;

/**
 *
 * @author vikton
 */

public class FactoryB1 implements Factory {
    @Override
    public Object create(Object... parameters) throws DependencyException {
        InterfaceD d;
        try {
            d = (InterfaceD) parameters[0];
        } catch (ClassCastException | ArrayIndexOutOfBoundsException ex) {
            throw new DependencyException(ex);
        }
        return new ImplementationB1(d);
    }
    
}
