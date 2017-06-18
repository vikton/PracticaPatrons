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
public class FactoryC1 implements Factory {
    @Override
    public Object create(Object... parameters)	throws	DependencyException {
	try{	
	String s = (String) parameters[0];	
        return new ImplementationC1 (s);
	} 
        catch (ClassCastException | ArrayIndexOutOfBoundsException ex) {	
        throw new DependencyException(ex);	
	}		
    }
}
			