package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.TaiKhoanBEAN;

/**
 * TaiKhoanDAO
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
public class TaiKhoanDAO {
	public TaiKhoanBEAN kTDangNhap(String adname, String pass) throws Exception{
		TaiKhoanBEAN tk=new TaiKhoanBEAN();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		String sql="select * from ADMININFOR where adname = ? and pass = ? ";
		PreparedStatement cmd=cs.cn.prepareStatement(sql);
		cmd.setString(1, adname);
		cmd.setString(2, pass);
		ResultSet rs=cmd.executeQuery();
		if(rs.next()) {
			tk.setAdname(rs.getString(1));
			tk.setPass(rs.getString(2));
		}else {
			tk=null;
		}
		rs.close();
		cs.cn.close();
		return tk;
	}
}
