package com.fcfm.tienda.models;

/**
 * Created by dany on 8/16/2015.
 */
public class Usuario {
    private int idUsuario;
    private String loginUsuario;
    private String password;
    private boolean administrador;
    private String nombreUsuario;
    private String apellidoUsuario;

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

    public Usuario(int idUsuario, String loginUsuario, String password, boolean administrador, String nombreUsuario, String apellidoUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
