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
    private byte[] imagenUsuario;
    private boolean administrador;
    private String nombreUsuario;
    private String apellidoUsuario;
    public Usuario(int idUsuario, String loginUsuario, String passwordUsuario, Date ultimoAccesoUsuario, byte[] imagenUsuario, boolean administrador, String nombreUsuario, String apellidoUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.passwordUsuario = passwordUsuario;
        this.ultimoAccesoUsuario = ultimoAccesoUsuario;
        this.imagenUsuario = imagenUsuario;
        this.administrador = administrador;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
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

    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }
}
