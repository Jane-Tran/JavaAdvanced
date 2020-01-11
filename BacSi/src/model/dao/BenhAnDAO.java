package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.BenhAnBEAN;

/**
 * BenhAnDAO
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
public class BenhAnDAO {
	
	/**
	 * Lay tat ca benh an
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BenhAnBEAN> getBenhAn() throws Exception{
		ArrayList<BenhAnBEAN> ds=new ArrayList<BenhAnBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		ResultSet rs=cs.getBang("Examine");
		while(rs.next()) {
			ds.add(new BenhAnBEAN(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
	/**
	 * Lay benh an theo Bac si
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BenhAnBEAN> getBenhAnTheoBacSy(String doctorID) throws Exception{
		ArrayList<BenhAnBEAN> ds=new ArrayList<BenhAnBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		String sql = "select * from Examine where DoctorID = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, doctorID);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			ds.add(new BenhAnBEAN(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
	/**
	 * xoa benh an
	 * 
	 * @param patientID
	 * @param doctorID
	 * @param examineDate
	 * @return
	 * @throws Exception
	 */
	public boolean xoaBenhAn(String patientID, String doctorID, String examineDate) {
		CoSoDAO cs=new CoSoDAO();
		try {
			cs.ketNoi();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String sql="delete from Examine where PatientID = ? and DoctorID = ? and ExamineDate = ?";
			PreparedStatement cmd=cs.cn.prepareStatement(sql);
			cmd.setString(1, patientID);
			cmd.setString(2, doctorID);
			cmd.setString(3,examineDate);
			int i=cmd.executeUpdate();
			cs.cn.close();
			
			System.out.println(i);
			if(i>=0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
