/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.excepcion;

/**
 *
 * @author Hector Rodriguez
 */
public class OperacionInvalidaException extends Exception{

    public OperacionInvalidaException() {
    }

    public OperacionInvalidaException(String message) {
        super(message);
    }
    
}
