/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.security.Principal;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import mx.zazil.service.UsuariosServiceHome;
/**
 *
 * @author Hector Rodriguez
 */
public class Login implements LoginModule{
    // private Logger log;
    private CallbackHandler callbackHandler;
    private Subject subject;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
    UsuarioBalam us;

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }
    
    public boolean login() throws LoginException {
        UsuariosServiceHome usr = this.lookupUsuariosBean();

        try {
            us = usr.login((String) options.get("usuario"), (String) options.get("contrasena"));
            if (us != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return false;
        }
    }

    public boolean commit() throws LoginException {
        try {
            String[] roles = us.getRoles().split(",");
            Set<Principal> ps = subject.getPrincipals();
            
            

            for (String r : roles) {
                ps.add(new mx.zazil.security.Principal(r));
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return false;
        }
    }

    public boolean abort() throws LoginException {
        
        this.us = null;
        this.subject = null;
        this.callbackHandler = null;
        this.sharedState = null;
        this.options = null;
       
        return true;
    }

    public boolean logout() throws LoginException {
        this.us = null;
        this.subject = null;
        this.callbackHandler = null;
        this.sharedState = null;
        this.options = null;
       
        return true;
    }

    private UsuariosServiceHome lookupUsuariosBean() {
        try {
            return (UsuariosServiceHome) CachingServiceLocator.getInstance().getRemoteHome("UsuariosServiceBean", UsuariosServiceHome.class);
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
