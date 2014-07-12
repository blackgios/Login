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
public class CapitalesTerceros extends Capitales implements Serializable{
    private double importeBruto;
    private double importeTotal;
    private double ivaCliente;
    private double comisionCliente;
    private double ivaBanregio;
    private double comisionBanregio;

    public double getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(double importeBruto) {
        this.importeBruto = importeBruto;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public double getIvaCliente() {
        return ivaCliente;
    }

    public void setIvaCliente(double ivaCliente) {
        this.ivaCliente = ivaCliente;
    }

    public double getComisionCliente() {
        return comisionCliente;
    }

    public void setComisionCliente(double comisionCliente) {
        this.comisionCliente = comisionCliente;
    }

    public double getIvaBanregio() {
        return ivaBanregio;
    }

    public void setIvaBanregio(double ivaBanregio) {
        this.ivaBanregio = ivaBanregio;
    }

    public double getComisionBanregio() {
        return comisionBanregio;
    }

    public void setComisionBanregio(double comisionBanregio) {
        this.comisionBanregio = comisionBanregio;
    }
}
