/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.banregio.contabilidad;

import java.io.Serializable;

/**
 *
 * @author Hector Rodriguez
 */
public class CapitalesPropia extends Capitales implements Serializable{
    private double importeBruto;
    private double iva;
    private double comision;
    private double precioVector;
    private double importeTotal;
    private double precio;

    public double getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(double importeBruto) {
        this.importeBruto = importeBruto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getPrecioVector() {
        return precioVector;
    }

    public void setPrecioVector(double precioVector) {
        this.precioVector = precioVector;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
