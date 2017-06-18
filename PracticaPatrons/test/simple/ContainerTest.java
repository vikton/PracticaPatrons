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
    public void testInjectorFA1() throws DependencyException {
        System.out.println("testinjectorIniciA");
        Injector injector = new Container();
        InterfaceD d = (InterfaceD) new FactoryD1().create(2);
        InterfaceB b = (InterfaceB) new FactoryB1().create(d);
        InterfaceC c = (InterfaceC) new FactoryC1().create("factoryc");
        
        injector.registerConstant("P", b);
        injector.registerConstant("Y", c);
        injector.registerFactory("A", new FactoryA1(), "P", "Y");
        
        InterfaceA a = (InterfaceA) injector.getObject("A");
        
        assertThat(a, is(instanceOf(ImplementationA1.class)));
        ImplementationA1 a1 = (ImplementationA1) a;
        
        assertThat(a1.b, is(b));
        assertThat(a1.c, is(c));
        System.out.println("testinjectorFinalA");
        
    }
    
    @Test
    public void testInjectorFB1() throws DependencyException {
        System.out.println("testinjectorIniciB");
        Injector injector = new Container();
        InterfaceD d = (InterfaceD) new FactoryD1().create(2);
        
        injector.registerConstant("K", d);
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
        System.out.println("registerConstantFinal");
    }
    
    @Test (expected=DependencyException.class)
    public void ExceptionRegisterConstant() throws Exception {
        System.out.println("registerConstantExceptionInici");
        Object value = 463;
        Container con = new Container();
        con.registerConstant("V", value);
        con.registerConstant("V", value);
        System.out.println("registerConstantExceptionFinal");
    }
    
    @Test (expected=DependencyException.class)
    public void ExceptionRegisterFactory() throws Exception {
        System.out.println("registerFactoryExceptionInici");
        Object value = 463;
        Container con = new Container();
        con.registerConstant("W", value);
        con.registerFactory("V", new FactoryD1(), "W");
        con.registerFactory("V", new FactoryD1(), "W");
        System.out.println("registerFactoryExceptionFinal");
    }
    
    @Test (expected=DependencyException.class)
    public void ExceptionGetObject() throws Exception {
        System.out.println("getObjectExceptionInici");
        Object value = 463;
        Container con = new Container();
        con.registerConstant("W", value);
        con.getObject("E");
        System.out.println("getObjectFactoryExceptionFinal");
    }
}
