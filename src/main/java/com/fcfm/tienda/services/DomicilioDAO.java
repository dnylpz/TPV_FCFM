package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Domicilio;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by jose.espinoza.lopez on 11/13/2015.
 */
public class DomicilioDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
    public  static Domicilio saveDomicilio(String pais,String estado, String ciudad, int codigoPostal, String colonia, String calle, String numero){
        Domicilio dom = new Domicilio(0,pais,estado,ciudad,codigoPostal,colonia,calle,numero);
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call saveDomicilio(?,?,?,?,?,?,?)");
            stmt.setString(1,pais);
            stmt.setString(2,estado);
            stmt.setString(3,ciudad);
            stmt.setInt(4,codigoPostal);
            stmt.setString(5,colonia);
            stmt.setString(6,calle);
            stmt.setString(7,numero);
            rs = stmt.executeQuery();
            while(rs.next()){
                dom.setId(rs.getInt(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        };
        return dom;
    }
    public static Domicilio getDomicilio(int id){
        Domicilio dom=null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getdomiciliobyid(?)");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while(rs.next()){
                dom = new Domicilio(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dom;
    }
}
