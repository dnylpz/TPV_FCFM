package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Producto;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jose.espinoza.lopez on 11/9/2015.
 */
public class ProductoServicios {
    public static boolean agregarProducto(String nombre, String descripcion, long UPC,Imagen imagen,float precio){
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto nuevo;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call saveproducto(?,?,?,?,?)");
            stmt.setString(1,nombre);
            stmt.setString(2,descripcion);
            stmt.setLong(3,UPC);
            if(imagen != null) {
                stmt.setInt(4, imagen.getIdImagen());
            }else{
                stmt.setNull(4,0);
            }
            stmt.setFloat(5,precio);
            stmt.execute();
            nuevo = getProductoWithUPC(UPC);
            if(nuevo != null){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    public static Producto getProductoWithUPC(long upc){
        Producto nuevo = null;
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        Connection conn =  null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getproductowithupc(?)");
            stmt.setLong(1,upc);
            rs = stmt.executeQuery();
            while(rs.next()){
                Imagen primg = ImagenServices.getImagen(rs.getInt(5));
                nuevo = new Producto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),primg,rs.getFloat(6));
                return nuevo;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
