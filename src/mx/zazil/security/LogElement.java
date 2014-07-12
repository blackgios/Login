/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.util.Date;

/**
 *
 * @author Hector Rodriguez
 */
public interface LogElement {
    String getTabla();
    String getTipo();
    String getUsuario();
    Date getDate();
    String getId();
}
