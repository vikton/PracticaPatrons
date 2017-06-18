/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import org.junit.Test;
import static org.junit.Assert.*;
import exemples.*;

/**
 *
 * @author vikton
 */
public class ContainerTest {
    
    public ContainerTest() {
    }
    
    /**
     * Test of registerConstant method, of class Container.
     */
    @Test
    public void testRegisterConstant() throws Exception {
        System.out.println("registerConstant");
        Object value = 383;
        Container con = new Container();
        con.registerConstant("I", value);
        assertEquals(383, con.mapconstant.get("I"));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerFactory method, of class Container.
     */
    @Test
    public void testRegisterFactory() throws Exception {
        System.out.println("registerFactory");
        Factory creator = new FactoryD1();
        Container con = new Container();
        con.registerFactory("D", creator, "I");
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObject method, of class Container.
     */
    @Test
    public void testGetObject() throws Exception {
        System.out.println("getObject");
        String name = "";
        Container instance = null;
        Object expResult = null;
        Object result = instance.getObject(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Container.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Object[] parameters = null;
        Container instance = null;
        Object expResult = null;
        Object result = instance.create(parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
