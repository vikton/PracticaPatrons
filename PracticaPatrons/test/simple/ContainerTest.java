/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import common.DependencyException;
import org.junit.Test;
import static org.junit.Assert.*;
import exemples.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 *
 * @author vikton
 */
public class ContainerTest {
    
    public ContainerTest() {
    }
    
    @Test
    public void testInjectorFB1() throws DependencyException {
        System.out.println("testinjectorIniciB");
        Injector injector = new Container();
        InterfaceD d = (InterfaceD) new FactoryB1().create(2);
        
        injector.registerConstant("K", 2);
        injector.registerFactory("J", new FactoryB1(), "K");
        
        InterfaceB b = (InterfaceB) injector.getObject("J");
        
        assertThat(b, is(instanceOf(ImplementationB1.class)));
        ImplementationB1 b1 = (ImplementationB1) b;
        
        assertThat(b1.d, is(d));
        System.out.println("testinjectorFinalB");
        
    }
    
    @Test
    public void testInjectorFC1() throws DependencyException {
        System.out.println("testinjectorIniciC");
        Injector injector = new Container();
        injector.registerConstant("K", "factoryc");
        injector.registerFactory("J", new FactoryC1(), "K");
        
        InterfaceC c = (InterfaceC) injector.getObject("J");
        
        assertThat(c, is(instanceOf(ImplementationC1.class)));
        ImplementationC1 c1 = (ImplementationC1) c;
        
        assertThat(c1.s, is("factoryc"));
        System.out.println("testinjectorFinalC");
        
    }
    
    @Test
    public void testInjectorFD1() throws DependencyException {
        System.out.println("testinjectorIniciD");
        Injector injector = new Container();
        injector.registerConstant("I", 56);
        injector.registerFactory("D", new FactoryD1(), "I");
        
        InterfaceD d = (InterfaceD) injector.getObject("D");
        
        assertThat(d, is(instanceOf(ImplementationD1.class)));
        ImplementationD1 d1 = (ImplementationD1) d;
        
        assertThat(d1.i, is(56));
        System.out.println("testinjectorFinalD");
        
    }
    
    @Test
    public void testRegisterConstant() throws Exception {
        System.out.println("registerConstantInici");
        Object value = 463;
        Container con = new Container();
        con.registerConstant("I", value);
        assertEquals(463, (Object) con.mapconstant.get("I"));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        System.out.println("registerConstantFinal");
    }
    
}
