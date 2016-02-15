package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Domicilio;
import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.models.Usuario;
import com.fcfm.tienda.utils.Utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

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
                    //TODO GET ADRESSS
                    Imagen usrImg = ImagenDAO.getImagen(rs.getInt("idUsuario"));
                    DomicilioDAO.getDomicilio(rs.getInt(12));
                    ses = new Usuario(rs.getInt("idUsuario"),rs.getString("loginUsuario"),
                            rs.getString("passwordUsuario"),rs.getDate("ultimoAccesoUsuario"),
                            usrImg, rs.getBoolean("administrador"),
                            rs.getString("nombreUsuario"), rs.getString("apellidosUsuario"),rs.getBoolean("sexo"),rs.getDate("fecha_nacimiento"),
                            rs.getString(11),null,rs.getString(13),rs.getString(14));
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
    //TODO ADD PARAMETERS
    public static boolean agregarUsuario(String user, String name, String apel, String pass, Imagen img, boolean isAdm,boolean sex,
                                         java.util.Date fNan, String  nDEs, Domicilio dom, String RFC, String CURP){
        String hash = Utils.hashPassword(pass);
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL saveusuario(?,?,?,?,?,?,?,?,?,?,?,?)");
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
            stmt.setBoolean(7,sex);
            Date fnac = new Date(fNan.getTime());
            stmt.setDate(8,fnac);
            stmt.setString(9,nDEs);
            try {
                stmt.setInt(10, dom.getId());
            }catch(NullPointerException npe){
                stmt.setNull(10,0);
            }
            stmt.setString(11,RFC);
            stmt.setString(12,CURP);
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
                java.sql.Date  d = rs.getDate(10);
                java.util.Date dat = null;
                if( d != null) {
                    dat = new java.util.Date(d.getTime());
                }
                Domicilio dom = DomicilioDAO.getDomicilio(rs.getInt(12));
                 result.add(new Usuario(rs.getInt("idUsuario"), rs.getString("loginUsuario"), rs.getString("passwordUsuario"),
                         rs.getDate("ultimoAccesoUsuario"), usrImg, rs.getBoolean("administrador"),
                         rs.getString("nombreUsuario"), rs.getString("apellidosUsuario"), rs.getBoolean(9), dat,
                         rs.getString(11), dom, rs.getString(13), rs.getString(14)));
                i++;
            }
            //rs.close();
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
            stmt = conn.prepareStatement("CALL getuserbyid(?)");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while(rs.next()){
                Imagen usrImg = ImagenDAO.getImagen(rs.getInt("fotoUsuario"));
                java.sql.Date  d = rs.getDate(10);
                java.util.Date dat = null;
                if(d!=null){
                dat = new java.util.Date(rs.getDate(10).getTime());
                }
                Domicilio dom = DomicilioDAO.getDomicilio(rs.getInt(12));
                result = new Usuario(rs.getInt("idUsuario"),rs.getString("loginUsuario"),rs.getString("passwordUsuario"),
                        rs.getDate("ultimoAccesoUsuario"),usrImg,rs.getBoolean("administrador"),
                        rs.getString("nombreUsuario"),rs.getString("apellidosUsuario"),rs.getBoolean(9),dat,
                        rs.getString(11),dom,rs.getString(13),rs.getString(14));
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static boolean updateUsuario(int idUser, String user, String name, String apel, String pass, Imagen img, boolean isAdm,
                                        boolean sex,java.util.Date fNan, String nDEs,Domicilio dom,String RFC, String CURP ){
        Usuario ant = getUsuarioById(idUser);
        String hspwd = Utils.hashPassword(pass);
        Usuario act = new Usuario(idUser,user,hspwd,null,img,isAdm,name,apel,sex,fNan,nDEs,dom,RFC,CURP);
        if(act.equals(ant)){
            return false;
        }else{
            MysqlDataSource ds = ConnectionFactory.getDataSource();
            try {
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("call updateusuario(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setInt(1,act.getIdUsuario());
                stmt.setString(2,act.getLoginUsuario());
                if(!ant.getPasswordUsuario().equals(pass)) {
                    stmt.setString(3, act.getPasswordUsuario());
                }else{
                    stmt.setString(3,act.getPasswordUsuario());
                }
                if(act.getFotoUsuario() != null){
                    stmt.setInt(4,act.getFotoUsuario().getIdImagen());
                } else{
                    if(ant.getFotoUsuario() != null) {
                        stmt.setInt(4, ant.getFotoUsuario().getIdImagen());
                    }else{
                        stmt.setNull(4,0);
                    }
                }
                stmt.setBoolean(5,act.isAdministrador());
                stmt.setString(6,act.getNombreUsuario());
                stmt.setString(7,act.getApellidoUsuario());
                stmt.setBoolean(8,act.isSexo());
                Date sqlDate = new Date(act.getFechaNacimiento().getTime());
                stmt.setDate(9,sqlDate);
                stmt.setString(10,nDEs);
                stmt.setInt(11,act.getDomicilio().getId());
                stmt.setString(12,act.getRfc());
                stmt.setString(13,act.getCurp());
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
