package com.fcfm.tienda.models;

/**
 * Created by jose.espinoza.lopez on 11/12/2015.
 */
public class Domicilio {
    private int id;
    private String pais;
    private String estado;
    private String ciudad;
    private int codigoPostal;
    private String colonia;
    private String calle;
    private String numero;

    public Domicilio(int id, String pais, String estado, String ciudad, int codigoPostal, String colonia, String calle, String numero) {
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
