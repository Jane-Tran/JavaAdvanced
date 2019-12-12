package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.khachhangbean;

public class khachhangdao {
	ConnectSQL con = new ConnectSQL();
	//Hàm xác thực người dùng
	public khachhangbean Authentication(String un, String pw) throws Exception {
		con.KetNoi();
		
		String sql="SELECT TOP 1 * FROM KhachHang WHERE tendn=? AND pass=? ";
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1,un);
		cmd.setString(2,pw);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		String makh =  rs.getString("makh");
		String tendn =  rs.getString("tendn");	
		String pass =  rs.getString("pass");
		String hoten =  rs.getString("hoten");
		khachhangbean khb= new khachhangbean(makh,tendn,pass,hoten);
		return khb;
	}
}
