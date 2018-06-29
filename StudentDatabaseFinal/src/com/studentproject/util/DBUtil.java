package com.studentproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection conn=null;
	
	
	public static Connection getConnect(){
		
		if(conn == null){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cs="jdbc:mysql://localhost:3306/batch1";
		
		try {
			conn=DriverManager.getConnection(cs,"root","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	
		return conn;
	}
	
	public static void closeConnection(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	

}
