/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

/**
 *
 * @author Hector Rodriguez
 */
public class UsuarioBalamImp implements UsuarioBalam {

    private String idUsuario = "";
    private String roles = "";
    private String nombreDeUsuario = "";
    private int perfil = 0;
    private String detalleUsuario;
    private String Status = "";

    public UsuarioBalamImp() {
    }

    public UsuarioBalamImp(String usu) {
        idUsuario = nombreDeUsuario = detalleUsuario = usu;
    }

    /**
     * @return the idUsuario
     */
    @Override
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the roles
     */
    @Override
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * @return the nombreDeUsuario
     */
    @Override
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * @param nombreDeUsuario the nombreDeUsuario to set
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * @return the perfil
     */
    @Override
    public int getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the detalleUsuario
     */
    @Override
    public String getDetalleUsuario() {
        return detalleUsuario;
    }

    /**
     * @param detalleUsuario the detalleUsuario to set
     */
    public void setDetalleUsuario(String detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

    /**
     * @return the Status
     */
    @Override
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
}