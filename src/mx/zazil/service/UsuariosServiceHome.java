/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.service;

import mx.zazil.security.UsuarioBalam;

/**
 *
 * @author Hector Rodriguez
 */
public interface UsuariosServiceHome {
    
    UsuarioBalam login(String Usuario, String Contrasena);

    public boolean puedeOperar(java.lang.String usuario, int operacion);

}
