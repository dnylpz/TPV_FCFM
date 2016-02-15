package com.fcfm.tienda.models;

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
    private boolean sexo;
    private Date fechaNacimiento;
    private String nivelDeEstudios;
    private Domicilio domicilio;
    private String rfc;
    private String curp;

    public Usuario(int idUsuario, String loginUsuario, String passwordUsuario, Date ultimoAccesoUsuario, Imagen fotoUsuario, boolean administrador, String nombreUsuario, String apellidoUsuario, boolean sexo, Date fechaNacimiento, String nivelDeEstudios, Domicilio domicilio, String rfc, String curp) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.passwordUsuario = passwordUsuario;
        this.ultimoAccesoUsuario = ultimoAccesoUsuario;
        this.fotoUsuario = fotoUsuario;
        this.administrador = administrador;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelDeEstudios = nivelDeEstudios;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.curp = curp;
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

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelDeEstudios() {
        return nivelDeEstudios;
    }

    public void setNivelDeEstudios(String nivelDeEstudios) {
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
