package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.BenhAnBEAN;

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
	 * Lấy dữ liệu từ bảng Examine
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
	 * Lấy dữ bệnh án theo bác sỹ
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

	public boolean xoaBenhAn(String patientID, String doctorID, Date examineDate) throws Exception{
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		String sql="delete from Examine where PatientID = ? and DoctorID = ? and ExamineDate =?";
		PreparedStatement cmd=cs.cn.prepareStatement(sql);
		cmd.setString(1, patientID);
		cmd.setString(2, doctorID);
		cmd.setDate(3, new java.sql.Date(examineDate.getTime()));
		cmd.executeUpdate();
		int i=cmd.executeUpdate();
		if(i>0)
			return true;
		return false;
	}
}
