package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Promocion;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    public static boolean savePromo(String tipoPromo, float valorPromo, Date vigencia, int prodId) {
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL savePromocion(?,?,?,?)");
            stmt.setString(1,tipoPromo);
            stmt.setFloat(2,valorPromo);
            stmt.setDate(3,new java.sql.Date(vigencia.getTime()));
            stmt.setInt(4,prodId);
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
