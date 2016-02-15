package com.fcfm.tienda.models;


import org.joda.time.LocalTime;

import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
public class Reporte {
    private int idDetalle;
    private String loginUsuario;
    private String nombreUsuario;
    private Date fechaDetalle;
    private LocalTime horaDetalle;
    private double total;
    private String formaDePago;
    private String nombreProducto;
    private double precioProducto;
    private float impuesto;
    private String tipoPromocion;
    private float valorPromocion;
    private Date vigencia;
    private double subtotal;
    private int productosVendidos;

    public Reporte(int idDetalle, String loginUsuario, String nombreUsuario, Date fechaDetalle, LocalTime horaDetalle, double total,
                   String formaDePago, String nombreProducto, double precioProducto, float impuesto, String tipoPromocion,
                   float valorPromocion, Date vigencia, double subtotal, int productosVendidos) {
        this.idDetalle = idDetalle;
        this.loginUsuario = loginUsuario;
        this.nombreUsuario = nombreUsuario;
        this.fechaDetalle = fechaDetalle;
        this.horaDetalle = horaDetalle;
        this.total = total;
        this.formaDePago = formaDePago;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.impuesto = impuesto;
        this.tipoPromocion = tipoPromocion;
        this.valorPromocion = valorPromocion;
        this.vigencia = vigencia;
        this.subtotal = subtotal;
        this.productosVendidos = productosVendidos;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaDetalle() {
        return fechaDetalle;
    }

    public void setFechaDetalle(Date fechaDetalle) {
        this.fechaDetalle = fechaDetalle;
    }

    public LocalTime getHoraDetalle() {
        return horaDetalle;
    }

    public void setHoraDetalle(LocalTime horaDetalle) {
        this.horaDetalle = horaDetalle;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public float getValorPromocion() {
        return valorPromocion;
    }

    public void setValorPromocion(float valorPromocion) {
        this.valorPromocion = valorPromocion;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(int productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
