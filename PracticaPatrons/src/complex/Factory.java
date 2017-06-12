/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex;
import common.DependencyException;

/**
 *
 * @author vikton
 */

public interface Factory <E> {
    E create (Object...	parameters) throws DependencyException;
}
