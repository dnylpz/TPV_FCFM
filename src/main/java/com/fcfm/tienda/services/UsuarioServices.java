package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.utils.Utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

/**
 * Created by jose.espinoza.lopez on 8/26/2015.
 */
public class UsuarioServices {
    public static Usuario getUsuario(String username, String password){
        Usuario ses= null;
        byte[] md5Result = null;
        String passHex = null;
        passHex = Utils.hashPassword(password);
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getusuariobyusername(?)");
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getString(3).equals(passHex)){
                    Imagen usrImg = ImagenServices.getImagen(rs.getInt("idUsuario"));
                    ses = new Usuario(rs.getInt("idUsuario"),rs.getString("loginUsuario"),
                            rs.getString("passwordUsuario"),rs.getDate("ultimoAccesoUsuario"),
                            usrImg, rs.getBoolean("administrador"),
                            rs.getString("nombreUsuario"), rs.getString("apellidosUsuario"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
                stmt.close();
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return ses;
    }
    public static boolean saveUsuario(String user, String name, String apel, String pass,Imagen img, Boolean isAdm ){

        String hash = Utils.hashPassword(pass);
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL saveusuario(?,?,?,?,?,?)");
            stmt.setString(1,user);
            stmt.setString(2,hash);
            if(img != null) {
                stmt.setInt(3, img.getIdImagen());
            }else{
                stmt.setNull(3,0);
            }
            stmt.setBoolean(4,isAdm);
            stmt.setString(5,name);
            stmt.setString(6,apel);
            stmt.execute();
            stmt.close();
            stmt = conn.prepareStatement("CALL getusuariobyusername(?)");
            stmt.setString(1,user);
            rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
