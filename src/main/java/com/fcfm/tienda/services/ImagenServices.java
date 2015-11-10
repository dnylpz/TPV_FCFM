package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Imagen;
import com.fcfm.tienda.utils.Utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.sql.*;

import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 10/27/2015.
 */
public class ImagenServices {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static Imagen getImagen(int fkid) {
        Imagen img = null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getimagenbyid(?)");
            stmt.setInt(1,fkid);
            rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getBytes("bytes") != null){
                    img = new Imagen(fkid,rs.getBlob("bytes"),rs.getString("tipoImagen"),
                    rs.getString("nombre"));
                    conn.close();
                    stmt.close();
                    rs.close();
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

        if(bytes != null) {
            try {
                conn = ds.getConnection();
                stmt = conn.prepareStatement("CALL saveimage(?,?,?)");
                stmt.setBlob(1, bytes);
                stmt.setString(2, type);
                stmt.setString(3, hashName);
                stmt.execute();
                stmt = conn.prepareStatement("CALL getimagenbynombre(?)");
                stmt.setString(1, hashName);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    foto = new Imagen(rs.getInt(1), bytes, type, hashName);
                }
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return foto;
    }
    public static Imagen parseImage(Part imagePart){
        byte[] foto;

        String fileName = getFileName(imagePart);
        String fileType = imagePart.getContentType();

        if(!fileName.equals("")){
            if(fileType.contains("image")){
                try {
                    InputStream is = imagePart.getInputStream();
                    int read = 0;
                    foto = new byte[1024];
                    while ((read = is.read(foto)) != -1){
                        System.out.println(read);
                    }
                    Blob img  = new SerialBlob(foto);
                    return imagenProvider(img,fileName,fileType);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            return null;
        }
        return null;
    }
    private static String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
