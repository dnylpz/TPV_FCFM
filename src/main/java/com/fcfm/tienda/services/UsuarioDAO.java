package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.utils.Utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 8/26/2015.
 */
public class UsuarioDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static Usuario getUsuario(String username, String password){
        Usuario ses= null;
        String passHex = null;
        passHex = Utils.hashPassword(password);
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getusuariobyusername(?)");
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getString(3).equals(passHex)){
                    Imagen usrImg = ImagenDAO.getImagen(rs.getInt("idUsuario"));
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
    public static boolean agregarUsuario(String user, String name, String apel, String pass, Imagen img, Boolean isAdm){
        String hash = Utils.hashPassword(pass);
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
                rs.close();
                stmt.close();
                conn.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Usuario> searchUsuarios(String param){
        List<Usuario> result = new ArrayList<Usuario>();
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL searchforusers(?)");
            stmt.setString(1,param);
            rs = stmt.executeQuery();
            int i =0;
            while(rs.next()){
                Imagen usrImg = ImagenDAO.getImagen(rs.getInt("fotoUsuario"));
                 result.add(new Usuario(rs.getInt("idUsuario"),rs.getString("loginUsuario"),rs.getString("passwordUsuario"),
                         rs.getDate("ultimoAccesoUsuario"),usrImg,rs.getBoolean("administrador"),
                         rs.getString("nombreUsuario"),rs.getString("apellidosUsuario")));
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static Usuario getUsuarioById(int id){
        Usuario result = null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getusuariobyid(?)");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while(rs.next()){
                Imagen usrimg = ImagenDAO.getImagen(rs.getInt("fotoUsuario"));
                result = new Usuario(id,rs.getString("loginUsuario"),rs.getString("passwordUsuario"),
                        rs.getDate("ultimoAccesoUsuario"),usrimg,rs.getBoolean("administrador"),
                        rs.getString("nombreUsuario"),rs.getString("apellidosUsuario"));
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static boolean updateUsuario(int idUser, String user, String name, String apel, String pass, Imagen img, Boolean isAdm){
        Usuario ant = getUsuarioById(idUser);
        String hspwd = Utils.hashPassword(pass);
        Usuario act = new Usuario(idUser,user,hspwd,null,img,isAdm,name,apel);
        String pswd = null;
        if(act.equals(ant)){
            return false;
        }else{
            MysqlDataSource ds = ConnectionFactory.getDataSource();
            try {
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("call updateusuario(?,?,?,?,?,?,?)");
                stmt.setInt(1,act.getIdUsuario());
                stmt.setString(2,act.getLoginUsuario());
                stmt.setString(3,act.getNombreUsuario());
                stmt.setString(4,act.getApellidoUsuario());
                stmt.setString(5,act.getPasswordUsuario());
                if(act.getFotoUsuario() != null){
                    stmt.setInt(6,act.getFotoUsuario().getIdImagen());
                } else{
                    if(ant.getFotoUsuario() != null) {
                        stmt.setInt(6, ant.getFotoUsuario().getIdImagen());
                    }else{
                        stmt.setNull(6,0);
                    }
                }
                stmt.setBoolean(7,act.isAdministrador());
                stmt.execute();
                stmt.close();
                conn.close();
                return true;
            }catch(Exception e){
                e.printStackTrace();
            }


        }
        return false;
    }
    public static boolean deleteUsuario(int idUser){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL deleteuser(?)");
            stmt.setInt(1,idUser);
            stmt.execute();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
