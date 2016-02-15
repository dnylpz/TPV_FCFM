package com.fcfm.tienda.models;

import org.joda.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/11/2015.
 */
public class Detalle {
    private int id;
    private FormaDePago formaDePago;
    //TODO private List<Impuesto> impuestos;
    //TODO private List<Promociones> promociones;
    private Usuario usuario;
    //TODO private Cliente cliente;
    private List<Producto> productos;
    private Date fecha;
    private LocalTime hora;
    private double total;



    public Detalle() {
        this.productos = new ArrayList<Producto>();
        this.fecha = new Date();
        this.hora = new LocalTime();
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "id=" + id +
                ", formaDePago=" + formaDePago +
                ", usuario=" + usuario +
                ", productos=" + productos +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", total=" + total +
                '}';
    }
}