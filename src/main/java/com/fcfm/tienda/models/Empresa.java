package com.fcfm.tienda.models;

/**
 * Created by jose.espinoza.lopez on 11/10/2015.
 */
public class Empresa {
    private int id;
    private String nombre;
    private String rfc;
    private Imagen logo;

    public Empresa(int id, String nombre, String rfc, Imagen logo) {
        this.id = id;
        this.nombre = nombre;
        this.rfc = rfc;
        this.logo = logo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Imagen getLogo() {
        return logo;
    }

    public void setLogo(Imagen logo) {
        this.logo = logo;
    }
}
