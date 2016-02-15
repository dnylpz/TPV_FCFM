package com.fcfm.tienda.models;

import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/9/2015.
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private long UPC;
    private Imagen imagen;
    private double  precio;
    private int existencia;
    private String departamento;
    private String uMedida;
    private List<Promocion> promociones;
    private float impuesto;

    public Producto(int idProducto, String nombre, String descripcion, long UPC,
                    Imagen imagen, double precio, int existencia, String departamento,
                    String uMedida, List<Promocion> promociones, float impuesto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.UPC = UPC;
        this.imagen = imagen;
        this.precio = precio;
        this.existencia = existencia;
        this.departamento = departamento;
        this.uMedida = uMedida;
        this.promociones = promociones;
        this.impuesto = impuesto;
    }


    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getuMedida() {
        return uMedida;
    }

    public void setuMedida(String uMedida) {
        this.uMedida = uMedida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;

        Producto producto = (Producto) o;

        if (getUPC() != producto.getUPC()) return false;
        if (Double.compare(producto.getPrecio(), getPrecio()) != 0) return false;
        if (getExistencia() != producto.getExistencia()) return false;
        if (!getNombre().equals(producto.getNombre())) return false;
        return !(getDescripcion() != null ? !getDescripcion().equals(producto.getDescripcion()) : producto.getDescripcion() != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getNombre().hashCode();
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        result = 31 * result + (int) (getUPC() ^ (getUPC() >>> 32));
        temp = Double.doubleToLongBits(getPrecio());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getExistencia();
        return result;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
