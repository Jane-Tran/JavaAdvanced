package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.bean.BenhNhanBEAN;

/**
 * BenhNhanDAO
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
public class BenhNhanDAO {
	
	/**
	 * Them moi benh nhan vao bang Patient
	 * @return
	 * @throws Exception
	 */
	public int themBenhNhan(String patientID, String patientName, String sex, Date birthDay, String address,String phoneNumber) throws Exception {
			CoSoDAO cs=new CoSoDAO();
			cs.ketNoi();
			String sql="insert into Patient(PatientID,PatientName,Sex,BirthDay,Address,PhoneNumber) values (?,?,?,?,?,?)";
			PreparedStatement statement=cs.cn.prepareStatement(sql);
			statement.setString(1, patientID);
			statement.setString(2, patientName);
			statement.setString(3, sex);
			statement.setDate(4, new java.sql.Date(birthDay.getTime()));
			statement.setString(5, address);
			statement.setString(6, phoneNumber);
			int kq=statement.executeUpdate();
			cs.cn.close();
			return kq;		
	}
	
	/**
	 * Lấy dữ liệu từ bảng Patient
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BenhNhanBEAN> getBenhNhan() throws Exception{
		ArrayList<BenhNhanBEAN> ds=new ArrayList<BenhNhanBEAN>();
		CoSoDAO cs=new CoSoDAO();
		cs.ketNoi();
		ResultSet rs=cs.getBang("Patient");
		while(rs.next()) {
			ds.add(new BenhNhanBEAN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
		}
		rs.close();
		cs.cn.close();
		return ds;
	}
	
	/**
	 * Kiem tra ma da ton tai hay chua
	 * @param patientId
	 * @return
	 */
	public boolean kiemTraTonTaiIDBenhNhan(String patientId) {
		try {
			CoSoDAO dc = new CoSoDAO();
			dc.ketNoi();
			String sqlTim ="select *from Patient where PatientId = ?";
			PreparedStatement cmd = dc.cn.prepareStatement(sqlTim);
			cmd.setString(1, patientId);
			ResultSet rs = cmd.executeQuery();
			if(rs.next() == true) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
