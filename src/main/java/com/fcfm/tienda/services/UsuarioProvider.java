package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.utils.ByteOperations;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Date;
/**
 * Created by jose.espinoza.lopez on 8/26/2015.
 */
public class UsuarioProvider {
    public static Usuario getUsuario(String username, String password){
        Usuario ses= null;
        byte[] md5Result = null;
        String passHex = null;
        try {
            MessageDigest md =  MessageDigest.getInstance("MD5");
            System.out.println("password digesting with " +md.getAlgorithm());
            byte [] passbytes = password.getBytes("UTF-8");
            md5Result = md.digest(passbytes);
            passHex = ByteOperations.ByteToHex(md5Result);
            System.out.println(passHex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        MysqlDataSource ds = ConnectionFactory.getDataSource();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL GETUSUARIOBYUSERNAME(?)");
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getString(3).equals(passHex)){
                    ses = new Usuario(rs.getInt("idUsuario"),rs.getString("loginUsuario"),
                            rs.getString("passwordUsuario"),rs.getDate("ultimoAccesoUsuario"),
                            rs.getBytes("fotoUsuario"), rs.getBoolean("administrador"),
                            rs.getString("nombreUsuario"), rs.getString("apellidosUsuario"));
                    return ses;
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ses;
    }
    public static boolean saveUsuario(Usuario sav){

        return true;
    }
}
