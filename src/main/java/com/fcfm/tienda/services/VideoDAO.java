package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Video;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 11/26/2015.
 */
public class VideoDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static Video getVideo(){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getlastvideo()");
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Video(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       return null;
    }
    public static Video getDefault(){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getdefaultvid()");
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Video(rs.getInt(1),rs.getString(2),rs.getString(3),null,rs.getString(4));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void updateDefault(Video a){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call updatedefvid(?,?,?)");
            stmt.setString(1,a.getNombre());
            stmt.setString(2,a.getTipo());
            stmt.setString(3,a.getPath());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void saveVideo(Video a){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL SAVEVIDEO(?,?,?,?)");
            stmt.setString(1,a.getNombre());
            stmt.setString(2,a.getTipo());
            stmt.setString(3,a.getPath());
            stmt.setDate(4,new java.sql.Date(a.getVigencia().getTime()));
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
