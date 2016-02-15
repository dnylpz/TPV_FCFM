package com.fcfm.tienda.models;

/**
 * Created by jose.espinoza.lopez on 11/13/2015.
 */
public class FormaDePago {
    private int id;
    private int tipo;
    private String nombre;

    public FormaDePago(int id, int tipo, String nombre) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
