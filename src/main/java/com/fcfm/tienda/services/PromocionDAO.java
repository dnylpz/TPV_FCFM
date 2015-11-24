package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Promocion;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/23/2015.
 */
public class PromocionDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;


    public static List<Promocion> getPromociones(int id){
        List<Promocion> resultado = new ArrayList<Promocion>();
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getpromociones(?)");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while(rs.next()){
                resultado.add(new Promocion(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4)));
            }
            if(resultado.size() >0) {
                return resultado;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
