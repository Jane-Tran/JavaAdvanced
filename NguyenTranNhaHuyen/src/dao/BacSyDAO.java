package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.BacSyBEAN;

/**
 * BacSyDAO
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
public class BacSyDAO {
	
	/**
	 * Lấy dữ liệu từ bảng Doctor
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BacSyBEAN> getBacSy() throws Exception{
		ArrayList<BacSyBEAN> ds=new ArrayList<BacSyBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		ResultSet rs=cs.getBang("Doctor");
		while(rs.next()) {
			ds.add(new BacSyBEAN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
}
