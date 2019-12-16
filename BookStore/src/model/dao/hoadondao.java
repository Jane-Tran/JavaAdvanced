package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.bean.hoadonbean;

public class hoadondao {
	ConnectSQL con = new ConnectSQL();
	public ArrayList<hoadonbean> getHoaDon(){
		ArrayList<hoadonbean> dsh = new ArrayList<hoadonbean>();
		try {
			con.KetNoi();
			String sql = "SELECT MaHoaDon,hoten,NgayMua,damua FROM hoadon JOIN KhachHang ON hoadon.makh = KhachHang.makh";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int mhd = rs.getInt("MaHoaDon");
				String mkh = rs.getString("hoten");
				Date nm = rs.getDate("ngaymua");
				boolean dm = rs.getBoolean("damua");
				hoadonbean hdb = new hoadonbean(mhd,mkh, nm, dm);
				dsh.add(hdb);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsh;
	}
	public ArrayList<hoadonbean> getHoaDon(String makh){
		ArrayList<hoadonbean> dsh = new ArrayList<hoadonbean>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM hoadon WHERE makh=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int mhd = rs.getInt("MaHoaDon");
				Date nm = rs.getDate("ngaymua");
				boolean dm = rs.getBoolean("damua");
				hoadonbean hdb = new hoadonbean(mhd, nm, dm);
				dsh.add(hdb);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsh;
	}
	
	public int confirm(String mahoadon){
		int kt=0;
		try {
			con.KetNoi();
			//Sua theo ten loai
			String sql = "UPDATE hoadon SET  damua= 1 WHERE MaHoaDon=? ";
			//Cho thuc hien cau lenh
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, mahoadon);
			kt=cmd.executeUpdate();
			cmd.close();
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kt;
	}
	
}
