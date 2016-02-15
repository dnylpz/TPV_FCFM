package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Detalle;
import com.fcfm.tienda.models.Producto;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

/**
 * Created by jose.espinoza.lopez on 11/13/2015.
 */
public class DetalleDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean saveDetalle(Detalle a){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call savedetalle(?,?,?,?,?)");
            Date fech = new Date(a.getFecha().getTime());
            stmt.setInt(1, a.getFormaDePago().getId());
            stmt.setInt(2,a.getUsuario().getIdUsuario());
            stmt.setDate(3, fech);
            stmt.setDouble(4,a.getTotal());
            stmt.setTime(5,new java.sql.Time(a.getHora().toDateTimeToday().getMillis()));
            rs = stmt.executeQuery();
            while(rs.next()){
                a.setId(rs.getInt(1));
            }
            stmt = conn.prepareStatement("call saveproductosventa(?,?)");
            for(Producto x : a.getProductos()){
                stmt.setInt(1,a.getId());
                stmt.setInt(2,x.getIdProducto());
                stmt.execute();
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
