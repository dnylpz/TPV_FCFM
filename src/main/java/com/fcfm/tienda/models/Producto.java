package com.fcfm.tienda.models;

/**
 * Created by jose.espinoza.lopez on 11/9/2015.
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private long UPC;
    private Imagen imagen;
    private float precio;

    public Producto(int idProducto, String nombre, String descripcion, long UPC, Imagen imagen, float precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.UPC = UPC;
        this.imagen = imagen;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getUPC() {
        return UPC;
    }

    public void setUPC(long UPC) {
        this.UPC = UPC;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
