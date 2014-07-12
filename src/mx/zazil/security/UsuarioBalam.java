/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.io.Serializable;

/**
 *
 * @author Hector Rodriguez
 */
public interface UsuarioBalam extends Serializable{
    
    String getRoles();

    String getNombreDeUsuario();

    public String getStatus();

    public int getPerfil();

    public String getDetalleUsuario();

    public String getIdUsuario();

}
