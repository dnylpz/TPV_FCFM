package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Reporte;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.joda.time.LocalTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
public class ReporteDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static List<Reporte> getReporteFechas(Date in, Date fin){
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("CALL getReporteFechas(?,?)");
            stmt.setDate(1,new java.sql.Date(in.getTime()));
            stmt.setDate(2,new java.sql.Date(fin.getTime()));
            rs = stmt.executeQuery();
            List<Reporte> resultado = new ArrayList<Reporte>();
            while(rs.next()){
                resultado.add(new Reporte(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),
                        new LocalTime(rs.getTime(5)),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getDouble(9),
                        rs.getFloat(10),rs.getString(11),rs.getFloat(12),rs.getDate(13),rs.getDouble(14),rs.getInt(15)));
            }
            return resultado;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
