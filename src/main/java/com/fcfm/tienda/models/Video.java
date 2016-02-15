package com.fcfm.tienda.models;

import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
public class Video {
    private int id;
    private String path;
    private Date vigencia;
    private String tipo;
    private String nombre;
    public Video(int id, String nombre, String path, Date vigencia, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.path = path;
        this.vigencia = vigencia;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
}
