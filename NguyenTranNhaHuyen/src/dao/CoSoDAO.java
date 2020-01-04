package dao;

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
	 * Kết nối với CSDL
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
	 * Lấy dữ liệu từ CSDL
	 * @return
	 * @throws Exception
	 */
	public ResultSet getBang(String tb) throws Exception{
		String sql="select * from "+tb;
		PreparedStatement statement=cn.prepareStatement(sql);
		return statement.executeQuery();
	}
	
	/**
	 * Đóng kết nối
	 * @return
	 * @throws Exception
	 */
	public void dongKetNoi() throws Exception{
		cn.close();
	}
}
