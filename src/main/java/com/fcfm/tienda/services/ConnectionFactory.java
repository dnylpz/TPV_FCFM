package com.fcfm.tienda.services;





import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.activation.DataSource;
import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jose.espinoza.lopez on 8/24/2015.
 */
public class ConnectionFactory  {
    private static ServletContext sc;
    public static void setServletContex(ServletContext context){
        sc = context;
    }
    public static MysqlDataSource getDataSource(){
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS= null;
        try{
            String x =sc.getRealPath("/WEB-INF/classes/db.properties");
            fis = new FileInputStream(x);
           // fis = fis.getClass().getClassLoader().getResourceAsStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return mysqlDS;
    }

}
