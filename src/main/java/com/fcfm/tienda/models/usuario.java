package com.fcfm.tienda.models;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by dany on 8/16/2015.
 */
public class Usuario {
    private int idUsuario;
    private String loginUsuario;
    private String passwordUsuario;
    private Date ultimoAccesoUsuario;
    private Imagen fotoUsuario;
    private boolean administrador;
    private String nombreUsuario;
    private String apellidoUsuario;

    public Usuario(int idUsuario, String loginUsuario, String passwordUsuario, Date ultimoAccesoUsuario,
                   Imagen fotoUsuario, boolean administrador, String nombreUsuario, String apellidoUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.passwordUsuario = passwordUsuario;
        this.ultimoAccesoUsuario = ultimoAccesoUsuario;
        this.fotoUsuario = fotoUsuario;
        this.administrador = administrador;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Date getUltimoAccesoUsuario() {
        return ultimoAccesoUsuario;
    }

    public void setUltimoAccesoUsuario(Date ultimoAccesoUsuario) {
        this.ultimoAccesoUsuario = ultimoAccesoUsuario;
    }

    public Imagen getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(Imagen fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (isAdministrador() != usuario.isAdministrador()) return false;
        if (!getLoginUsuario().equals(usuario.getLoginUsuario())) return false;
        if (!getPasswordUsuario().equals(usuario.getPasswordUsuario())) return false;;
        if (getNombreUsuario() != null ? !getNombreUsuario().equals(usuario.getNombreUsuario()) : usuario.getNombreUsuario() != null)
            return false;
        return !(getApellidoUsuario() != null ? !getApellidoUsuario().equals(usuario.getApellidoUsuario()) : usuario.getApellidoUsuario() != null);

    }

    @Override
    public int hashCode() {
        int result = getLoginUsuario().hashCode();
        result = 31 * result + getPasswordUsuario().hashCode();
        result = 31 * result + (getUltimoAccesoUsuario() != null ? getUltimoAccesoUsuario().hashCode() : 0);
        result = 31 * result + (isAdministrador() ? 1 : 0);
        result = 31 * result + (getNombreUsuario() != null ? getNombreUsuario().hashCode() : 0);
        result = 31 * result + (getApellidoUsuario() != null ? getApellidoUsuario().hashCode() : 0);
        return result;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
