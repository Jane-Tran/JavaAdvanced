package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.BenhAnNamBEAN;

/**
 * BenhAnNamDAO
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
public class BenhAnNamDAO {
	
	/**
	 * Lấy dữ liệu từ View_BenhAnNam
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BenhAnNamBEAN> getBenhAnNam() throws Exception{
		ArrayList<BenhAnNamBEAN> ds=new ArrayList<BenhAnNamBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		ResultSet rs=cs.getBang("View_BenhAnNam");
		while(rs.next()) {
			ds.add(new BenhAnNamBEAN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
	/**
	 * Danh sach benh an theo nam
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BenhAnNamBEAN> listBenhAnNam(int nam) throws Exception{
		ArrayList<BenhAnNamBEAN> list = new ArrayList<BenhAnNamBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		String query = "SELECT * FROM Examine where YEAR(ExamineDate) = ?";
		PreparedStatement stmt = cs.cn.prepareStatement(query);
		stmt.setInt(1, nam);
		ResultSet rs = stmt.executeQuery();
		BenhAnNamBEAN tmp = null;
		while(rs.next()) {
			tmp = new BenhAnNamBEAN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7));
			list.add(tmp);
		}
		stmt.close();
		cs.cn.close();
		return list;
	}
}
