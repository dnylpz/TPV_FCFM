package com.fcfm.tienda.models;

import java.sql.Blob;

/**
 * Created by jose.espinoza.lopez on 10/27/2015.
 */
public class Imagen {
    private int idImagen;
    private Blob bytes;
    private String tipoImagen;
    private String nombre;

    public Imagen(Blob bytes, String tipoImagen, String nombre) {
        this.bytes = bytes;
        this.tipoImagen = tipoImagen;
        this.nombre = nombre;
    }

    public Imagen(int idImagen, Blob bytes, String tipoImagen, String nombre) {
        this.idImagen = idImagen;
        this.bytes = bytes;
        this.tipoImagen = tipoImagen;
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public Blob getBytes() {
        return bytes;
    }

    public void setBytes(Blob bytes) {
        this.bytes = bytes;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
