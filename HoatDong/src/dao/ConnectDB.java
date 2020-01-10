package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectDB
 * 
 * Version 1.0
 * 
 * Date: 11-01-2020
 * 
 * Copyright
 * 
 * Modification Logs:
 * 
 * DATE-----------AUTHOR------DESCRIPTION
 * 
 * 12-11-2013-----HuyTran-------Create
 * 
 */

public class ConnectDB {
	public Connection cn;

	String DB_USERNAME = "sa";
	String DB_PASSWORD = "123";
	String DB_DBNAME = "HoatDong";
	String DB_URL = String.format("jdbc:sqlserver://localhost:1433;databaseName=%s;user=%s;password=%s", DB_DBNAME,
			DB_USERNAME, DB_PASSWORD);
	String DB_DRV = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	/**
	 * Connect with SQL server
	 * 
	 */
	public void KetNoi() throws Exception {
		Class.forName(DB_DRV);
		cn = DriverManager.getConnection(DB_URL);
		System.out.println("kt!");
	}
	
}
