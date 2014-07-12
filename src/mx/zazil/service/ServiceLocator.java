/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.service;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

/**
 *
 * @author Hector Rodriguez
 */
public class ServiceLocator {
    private static ServiceLocator me;
    private InitialContext ic;
    
    private ServiceLocator() {
        try {
            ic = new InitialContext();
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
    
     public static ServiceLocator getInstance() {
        if(me == null)
            me = new ServiceLocator();
        return me;
    }
    
    private Object lookup(String jndiName) throws NamingException {
        Object cachedObj;
        try {
            cachedObj = ic.lookup(jndiName);
        } catch (Exception e) {
            jndiName = "java:/" + jndiName;
            cachedObj = ic.lookup(jndiName);          
        }
        return cachedObj;
    }
    
    /**
     * This method obtains the datasource itself for a caller
     * @return the DataSource corresponding to the name parameter
     */
    public DataSource getDataSource(String dataSourceName) throws NamingException {
        return (DataSource) lookup(dataSourceName);
    } 

    public Object getRemoteHome(String jndiHomeName, Class className) throws NamingException {
        Object objref = lookup(jndiHomeName + "/remote");
        //Object objref = lookup(jndiHomeName);
        return PortableRemoteObject.narrow(objref, className);
    }
}
