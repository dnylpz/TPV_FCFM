package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Producto;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/9/2015.
 */
public class ProductoDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static boolean agregarProducto(String nombre, String descripcion, long UPC, Imagen imagen, double precio, int existencia) {
        Producto nuevo;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL saveproducto(?,?,?,?,?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setLong(3, UPC);
            if (imagen != null) {
                stmt.setInt(4, imagen.getIdImagen());
            } else {
                stmt.setNull(4, 0);
            }
            stmt.setDouble(5, precio);
            stmt.setInt(6, existencia);
            stmt.execute();
            nuevo = getProductoWithUPC(UPC);
            if (nuevo != null) {
                conn.close();
                stmt.close();
                rs.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Producto getProductoWithUPC(long upc) {
        Producto nuevo = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getproductowithupc(?)");
            stmt.setLong(1, upc);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imagen primg = ImagenDAO.getImagen(rs.getInt(5));
                nuevo = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), primg, rs.getDouble(6), rs.getInt(7));
                conn.close();
                stmt.close();
                rs.close();
                return nuevo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Producto> buscaProducto(String searchParam) {
        List<Producto> result = new ArrayList<Producto>();
        Producto p;
        Imagen primg;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL searchproduct(?)");
            stmt.setString(1, searchParam);
            rs = stmt.executeQuery();
            while (rs.next()) {
                primg = ImagenDAO.getImagen(rs.getInt(5));
                p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), primg, rs.getDouble(6), rs.getInt(7));
                result.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Producto getProductoWithId(int id) {
        Producto nuevo = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getproductowithid(?)");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imagen primg = ImagenDAO.getImagen(rs.getInt(5));
                nuevo = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), primg, rs.getDouble(6), rs.getInt(7));
                conn.close();
                stmt.close();
                rs.close();
                return nuevo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateProducto(int id,String nombre, String descripcion, long UPC, Imagen img, double precio, int existencia) {
        Producto ant = getProductoWithId(id);
        Producto nuev = new Producto(id,nombre,descripcion,UPC,img,precio,existencia);
        if(ant.equals(nuev)){
            return false;
        }else{
            try {
                conn = ds.getConnection();
                stmt = conn.prepareStatement("call updateproducto(?,?,?,?,?,?,?)");
                stmt.setInt(1, nuev.getIdProducto());
                stmt.setString(2,nuev.getNombre());
                stmt.setString(3,nuev.getDescripcion());
                stmt.setLong(4, nuev.getUPC());
                if(nuev.getImagen() != null){
                    stmt.setInt(5,nuev.getImagen().getIdImagen());
                }else{
                    if(ant.getImagen()!= null){
                     stmt.setInt(5,ant.getImagen().getIdImagen());
                    }else {
                        stmt.setNull(5, 0);
                    }
                }
                stmt.setDouble(6,nuev.getPrecio());
                stmt.setInt(7,nuev.getExistencia());
                stmt.execute();
                stmt.close();
                ant = getProductoWithId(id);
                if(ant.equals(nuev)){
                    stmt.close();
                    conn.close();
                    return true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try{
                    stmt.close();
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean deleteProducto(int id){
        Producto check;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call deleteproducto(?)");
            stmt.setInt(1,id);
            stmt.execute();
            check = getProductoWithId(id);
            if(check == null){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
                stmt.close();
            }catch(SQLException e ){
                e.printStackTrace();
            }
        }
        return false;
    }
}
