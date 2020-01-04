package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DotUngHoDAO {
	ConnectDb con =  new ConnectDb();
	
	public boolean checkMaDotUngHo() throws Exception {
		String sql = "SELECT MaDotUngHo FROM DOT_UNG_HO";
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		boolean kt = rs.next();
		rs.close();
		return kt;
	}
	
	public boolean addDotUngHo() throws Exception {
		con.KetNoi();
		String sql = "";
		boolean kt;
		return kt;
	}
}
