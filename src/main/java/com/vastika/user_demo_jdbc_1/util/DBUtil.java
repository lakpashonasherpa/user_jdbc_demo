package com.vastika.user_demo_jdbc_1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3307/user_db_demo";
	public static final String USER="root";
	public static final String PASSWORD="root";
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD); 
		
	}
}
