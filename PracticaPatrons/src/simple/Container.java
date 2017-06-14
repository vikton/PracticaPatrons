/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import common.DependencyException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vikton
 */
public class Container implements Injector, Factory {
    
    Map<String, Object> mapconstant = new HashMap<>();
    Map<String, Factory> mapfactory = new HashMap<>();
    
    @Override
    public void registerConstant(String name, Object value) throws DependencyException {
        if (mapconstant.containsKey(name)) {
            throw new DependencyException("This name is already registred");
        }
        else {
            mapconstant.put(name, value);
        }
    }				
    
    @Override
    public void registerFactory(String	name, Factory creator, String... parameters) throws DependencyException {
        Object[] pars = parameters;
        create (pars);

        if (mapfactory.containsKey(name)) {
            throw new DependencyException("This name is already registred");
        }
        else {
            mapconstant.put(name, creator);

        }
    }				
    
    @Override
    public Object getObject(String name) throws DependencyException {
        if (mapconstant.containsKey(name)) {
            return mapconstant.get(name);
        }
        else if (mapfactory.containsKey(name)) {
            return mapfactory.get(name);
        }
        else {
            throw new DependencyException("No object with this name");
        }
    }
    
    @Override
    public Object create(Object... parameters)	throws	DependencyException {
        return 1;
    }
}
