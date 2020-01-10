package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * CoSoDAO
 * 
 * Date: 15-12-2018
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * -------------------------------------
 * 15-12-2018	NhaHuyen		Create
 */
public class CoSoDAO {
	public Connection cn;
	
	/**
	 * Káº¿t ná»‘i vá»›i CSDL
	 * @return
	 * @throws Exception
	 */
	public void ketNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://NHAHUYEN-PC\\SQLEXPRESS:1433;databaseName=QuanLyPhongKhamBenh;user=sa; password=123");
		System.out.println("Da ket noi");
	}
	
	/**
	 * Láº¥y dá»¯ liá»‡u tá»« CSDL
	 * @return
	 * @throws Exception
	 */
	public ResultSet getBang(String tb) throws Exception{
		String sql="select * from "+tb;
		PreparedStatement statement=cn.prepareStatement(sql);
		return statement.executeQuery();
	}
	
	/**
	 * Ä�Ã³ng káº¿t ná»‘i
	 * @return
	 * @throws Exception
	 */
	public void dongKetNoi() throws Exception{
		cn.close();
	}
}
