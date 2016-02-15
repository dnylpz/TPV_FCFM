package com.fcfm.tienda.services;

import com.fcfm.tienda.models.FormaDePago;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 11/13/2015.
 */
public class FormaDePagoDAO {
    private static MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static FormaDePago getMetodoDePago(int id){
        FormaDePago mdp =null;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getformadepago(?)");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while(rs.next()){
                mdp = new FormaDePago(rs.getInt(1),rs.getInt(2),rs.getString(3));
            }
        }catch(SQLException sqe){
            sqe.printStackTrace();
        }
        return mdp;
    }
}
