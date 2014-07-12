/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.banregio.contabilidad;

import java.util.Date;

/**
 *
 * @author Hector Rodriguez
 */
public class VectorCapitales {
    private String tipoValor;
    private String emisora;
    private String serie;
    private Date fecha;
    private double precio;

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    public String getEmisora() {
        return emisora;
    }

    public void setEmisora(String emisora) {
        this.emisora = emisora;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
