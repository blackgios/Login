/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/* Paquete javax.faces no incluido en javaSE añadirlo a NetBeans
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
*/
/**
 *
 * @author Hector Rodriguez
 */
public class Redirect {
    public static void redireccionaCatalogo(ExternalContext ex, Properties p, String moduloOrigen, String moduloDestino, String catalogo){
        try {
            // TODO: Process the button click action. Return value is a navigation
            // case name where null will return to the same page.
            // this.getExternalContext().redirect("http://www.google.com");
            //this.getExternalContext().r
            //HttpServletRequest sc =  (HttpServletRequest)  this.getExternalContext().getRequest();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalCtx = facesContext.getExternalContext();
            String URL;
            URL = "http://localhost:8080/"+ moduloDestino+catalogo;
            externalCtx.redirect(URL);
        } catch (IOException ioex) {
            Logger.getLogger(Redirect.class.getName()).log(Level.SEVERE, null, ioex);
        }
    }
}
