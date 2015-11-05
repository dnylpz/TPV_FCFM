package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.utils.Utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 10/27/2015.
 */
public class ImagenServices {
    public static Imagen getImagen(int usuarioid) {
        Imagen img = null;
        MysqlDataSource ds = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            ds = ConnectionFactory.getDataSource();
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getimagenbyid(?)");
            stmt.setInt(1,usuarioid);
            rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getBytes("bytes") != null){
                    img = new Imagen(usuarioid,rs.getBlob("bytes"),rs.getString("tipoImagen"),
                    rs.getString("nombre"));
                    return img;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return img;
    }
    public static Imagen imagenProvider(Blob bytes,String name, String type){
        Imagen foto = null;
        name += new java.util.Date().toString();
        String hashName = Utils.hashPassword(name);
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        if(bytes != null) {
            try {
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("CALL saveimage(?,?,?)");
                stmt.setBlob(1, bytes);
                stmt.setString(2, type);
                stmt.setString(3, hashName);
                stmt.execute();
                stmt = conn.prepareStatement("CALL getimagenbynombre(?)");
                stmt.setString(1, hashName);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    foto = new Imagen(rs.getInt(1), bytes, type, hashName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return foto;
    }
}
