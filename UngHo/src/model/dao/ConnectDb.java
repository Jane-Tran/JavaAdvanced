package model.dao;

import java.sql.*;

public class ConnectDb {
	public Connection cn;
	public void KetNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=UngHoLuLut;user=sa;password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("kt!");
	}
}
