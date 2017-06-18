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
public class FactoryA1 implements Factory {
    @Override
    public Object create(Object... parameters) throws DependencyException {
        InterfaceB b;
        InterfaceC c;
        try {
            b = (InterfaceB) parameters[0];
            c = (InterfaceC) parameters[1];
        } catch (ClassCastException | ArrayIndexOutOfBoundsException ex) {
            throw new DependencyException(ex);
        }
        return new ImplementationA1(b, c);
    }
    
}
