/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
/*Paquete javax.jms y javax.mail no incluido en javaSE, se incluye en las librerias del servidor, añadir a netbeans
    import javax.jms.ConnectionFactory;
    import javax.jms.Destination;
    import javax.mail.Session;
*/
/**
 *
 * @author Hector Rodriguez
 */
public class CachingServiceLocator {
    private InitialContext ic;
    private Map cache;
    
    private static CachingServiceLocator me;
    
    static {
        try {
            me = new CachingServiceLocator();
        } catch(NamingException se) {
            throw new RuntimeException(se);
        }
    }
    
    private CachingServiceLocator() throws NamingException  {
        ic = new InitialContext();
        cache = Collections.synchronizedMap(new HashMap());
    }
    
    public static CachingServiceLocator getInstance() {
        return me;
    }

    private Object lookup(String jndiName) throws NamingException {
        
        Object cachedObj = cache.get(jndiName);
        if (cachedObj == null) {
            
            Logger.getLogger("ServiceLocator").log(Level.INFO, "jndiName: '"+jndiName+"'");
            
            try{
                cachedObj = ic.lookup(jndiName);
                cache.put(jndiName, cachedObj);
            }catch(Exception e){
                jndiName ="Balam/" + jndiName;
                cachedObj = ic.lookup(jndiName);
                cache.put(jndiName, cachedObj);
                Logger.getLogger("ServiceLocator").log(Level.INFO, "Ahora, jndiName: '"+jndiName+"'");
            }
        }
        return cachedObj;
    }
    
    /**
     * will get the ejb Local home factory. If this ejb home factory has already been
     * clients need to cast to the type of EJBHome they desire
     *
     * @return the EJB Home corresponding to the homeName
     */
    public Object getLocalHome(String jndiHomeName) throws NamingException {
        return  lookup(jndiHomeName + "/local");
    }
    
    /**
     * will get the ejb Remote home factory. If this ejb home factory has already been
     * clients need to cast to the type of EJBHome they desire
     *
     * @return the EJB Home corresponding to the homeName
     */
    public Object getRemoteHome(String jndiHomeName, Class className) throws NamingException {
        Object objref = lookup(jndiHomeName + "/remote");
        return  PortableRemoteObject.narrow(objref, className); 
    }
    
    /**
     * This method helps in obtaining the topic factory
     * @return the factory for the factory to get topic connections from
     */
    public ConnectionFactory getConnectionFactory(String connFactoryName) throws NamingException {
        return (ConnectionFactory) lookup(connFactoryName);
    }
    
    /**
     * This method obtains the topc itself for a caller
     * @return the Topic Destination to send messages to
     */
    public Destination getDestination(String destName) throws NamingException {
        return (Destination) lookup(destName);
    }
    
    /**
     * This method obtains the datasource 
     * @return the DataSource corresponding to the name parameter
     */
    public DataSource getDataSource(String dataSourceName) throws NamingException {
        return (DataSource) lookup(dataSourceName);
    }

    /**
     * This method obtains the mail session 
     * @return the Session corresponding to the name parameter
     */
    public Session getSession(String sessionName) throws NamingException {
        return (Session) lookup(sessionName);
    }
    
    /**
     * @return the URL value corresponding
     * to the env entry name.
     */
    public URL getUrl(String envName) throws NamingException {
        return (URL) lookup(envName);
    }
    
    /**
     * @return the boolean value corresponding
     * to the env entry such as SEND_CONFIRMATION_MAIL property.
     */
    public boolean getBoolean(String envName) throws NamingException {
        Boolean bool = (Boolean) lookup(envName);
        return bool.booleanValue();
    }
    
    /**
     * @return the String value corresponding
     * to the env entry name.
     */
    public String getString(String envName) throws NamingException {
        return (String) lookup(envName);
    }
}
