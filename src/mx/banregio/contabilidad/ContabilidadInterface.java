/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.banregio.contabilidad;

import mx.zazil.service.Pingeable;

/**
 *
 * @author Hector Rodriguez
 */
public interface ContabilidadInterface extends Pingeable{
    
    public void generaPolizaCapitalesCuentaPropiaValuacion(CapitalesPropia capPropia);
    
    public boolean generaPolizaCapitalesTerceros(CapitalesTerceros capTerceros);
    
    public boolean generaPolizaCapitalesCuentaPropiaConcentracion(CapitalesPropia capPropia);
    
    public boolean generaPolizaCapitalesCuentaPropiaLiquidacion(CapitalesPropia capPropia);
    
}
