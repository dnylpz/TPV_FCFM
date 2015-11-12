package com.fcfm.tienda.services;

import com.fcfm.tienda.models.Empresa;
import com.fcfm.tienda.models.Imagen;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jose.espinoza.lopez on 11/10/2015.
 */
public class EmpresaDAO {
    private static final MysqlDataSource ds = ConnectionFactory.getDataSource();
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    public static Empresa empresaFactory(){
        Empresa empresa=null;
        Imagen logo;
        try{
            conn = ds.getConnection();
            stmt = conn.prepareStatement("call getEmpresa()");
            rs = stmt.executeQuery();
            while(rs.next()){
                logo = ImagenDAO.getImagen(rs.getInt(4));
                empresa = new Empresa(rs.getInt(1),rs.getString(2),rs.getString(3),logo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
                stmt.close();
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return empresa;
    }
}
