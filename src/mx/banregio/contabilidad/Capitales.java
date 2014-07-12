/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.banregio.contabilidad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hector Rodriguez
 */
public abstract class Capitales implements Serializable{
    
    protected boolean compra;
    protected String transaccion;
    private Date fecha;
    
    public String getTransaccion(){
        return transaccion;
    }
    
    public void setTransaccion(String transaccion){
        this.transaccion = transaccion;
    }
    
    public boolean isCompra(){
        return compra;
    }
    
    public void setCompra(boolean compra){
        this.compra = compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
