/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;

/**
 *
 * @author Syndein
 */
public class Conexion {
    public static Connection con_mysql;
        public static String host="localhost";
        public static String user="root";
        public static String pas="";
        public static String db="bdblog";
                
	public Connection conectar() throws Exception {
		try {
			String databaseURL = "jdbc:mysql://" + host + "/" + db;
			Class.forName("com.mysql.jdbc.Driver");
			con_mysql = java.sql.DriverManager.getConnection(databaseURL, user, pas);
			//System.out.println("Conexion con MySQL Establecida..");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return con_mysql;
	}
    
}
