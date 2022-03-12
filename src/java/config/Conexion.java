/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Brayan Carrasco
 */
public class Conexion {
    
    final String DRIVER="com.mysql.cj.jdbc.Driver";
    final String URL="132.226.240.106";
    final String PUERTO="3306";
    final String DATABASE="db_garzasoftproject";
    final String USER="garzasoft";
    final String PASSWORD="garzasoft1234";
    
    private Connection cn;
    
    

    public Connection getCn() {
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(String.format("jdbc:mysql://%s/%s/",URL,PUERTO),
                    USER, PASSWORD);
            return cn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //CUD
    public boolean ejecutar(String sql,Object[] parametros) throws Exception {
        PreparedStatement ps;
        try {
            if (getCn() == null) {
            } else {
                ps = this.getCn().prepareStatement(sql);
                for (int i = 0; i < parametros.length; i++) {
                    ps.setObject(i+1, parametros[i]);
                }
                ps.executeUpdate();
            }
            
            return true;
        } catch (Exception e) {
            throw e;
        }finally{
            cn.close();
        }
    }

    //R
    public ResultSet recuperar(String sql) throws SQLException {
        Statement st;
        try {
            if (getCn() == null) {
                return null;
            } else {
                st = this.getCn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                return st.executeQuery(sql);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
