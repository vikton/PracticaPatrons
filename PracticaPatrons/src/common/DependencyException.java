/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author vikton
 */

public class DependencyException extends Exception {

    public DependencyException(Exception cause)	{
        super(cause);
    }
    
    public DependencyException(String message) {
        super(message);
    }
}
