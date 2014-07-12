/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.lang.reflect.Method;
import javax.security.auth.login.LoginException;
/**
 *
 * @author Hector Rodriguez
 */
public class SecurityAspect {
    public static void puedeEjecutar(Set<String> roles, Class c) throws LoginException {
        try {
           
            
            Rol r = (Rol) c.getAnnotation(Rol.class);
            
            if (r == null) {
                Logger.getLogger("banderitas").log(Level.INFO, "No tiene roles, por lo tanto asumimos que si tiene permiso" + c);
                return;
            }
            for (String s : r.rol()) {
                if (roles.contains(s)) {
                    Logger.getLogger("banderitas").log(Level.INFO, "Estoy Aqui =>>>>>>>>>>>>>" + s);
                    return;
                }
            }
            throw new LoginException("El usuario no tiene permiso");
        } catch (SecurityException ex) {
            Logger.getLogger(SecurityAspect.class.getName()).log(Level.SEVERE, ex.getMessage());
        } 
    }
    
    public static void puedeEjecutar(Set<String> roles) throws LoginException {
        try {
            Thread t = Thread.currentThread();
            StackTraceElement[] stackTrace = t.getStackTrace();
            Class c = Class.forName(stackTrace[2].getClassName());
            stackTrace[2].getLineNumber();
            Rol r = null;
            String metodo = stackTrace[2].getMethodName();
            for (Method m : c.getMethods()) {
                if (metodo.equals(m.getName())) {
                    r = m.getAnnotation(Rol.class);
                    if (r != null) {
                        break;
                    }
                }
            }
            if (r == null) {
                System.out.println("No tiene roles, por lo tanto asumimos que si tiene permiso" + stackTrace[2].getMethodName());
                return;
            }
            for (String s : r.rol()) {
                if (roles.contains(s)) {
                    return;
                }
            }
            throw new LoginException("El usuario no tiene permiso");
        } catch (SecurityException ex) {
            Logger.getLogger(SecurityAspect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecurityAspect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
