package com.fcfm.tienda.models;

import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/23/2015.
 */
public class Promocion {
    private int id;
    private String tipo;
    private float valor;
    private Date vigencia;

    public Promocion(int id, String tipo, float valor, Date vigencia) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.vigencia = vigencia;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
}
