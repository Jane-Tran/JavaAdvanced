package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ConnectDB
 * 
 * Date: 11-01-2020
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * -------------------------------------
 * 11-01-2020	HuyTran		Create
 */
public class ConnectDB {
	public Connection cn;

	final String DB_USERNAME = "sa";
	final String DB_PASSWORD = "123";
	final String DB_DBNAME = "HoatDong";
	final String DB_URL = String.format("jdbc:sqlserver://localhost:1433;databaseName=%s;user=%s;password=%s", DB_DBNAME,
			DB_USERNAME, DB_PASSWORD);
	final String DB_DRV = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	/**
	 * Connect with SQL server
	 * 
	 */
	public void ketNoi() throws Exception {
		Class.forName(DB_DRV);
		cn = DriverManager.getConnection(DB_URL);
		System.out.println("kt!");
	}
	
	/**
	 * Get table from CSDL
	 * 
	 * @param tb
	 * @return
	 * @throws Exception
	 */
	public ResultSet getBang(String tb) throws Exception{
		String sql="SELECT * FROM"+tb;
		PreparedStatement statement=cn.prepareStatement(sql);
		return statement.executeQuery();
	}
	
}
