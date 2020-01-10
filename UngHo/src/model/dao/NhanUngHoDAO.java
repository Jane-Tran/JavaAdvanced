package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.NhanUngHoBEAN;

public class NhanUngHoDAO {
	ConnectDb con = new ConnectDb();
	/*
	 * Lấy thông tin danh sách đợt nhận ủng hộ
	 * */
	 public ArrayList<NhanUngHoBEAN> getListNUH(){
		 ArrayList<NhanUngHoBEAN> list = new ArrayList<NhanUngHoBEAN>();
		 try {
			con.KetNoi();
			String sql= "SELECT * FROm DOT_NHAN_UNG_HO AS nuh JOIN CHI_TIET_DOT_NHAN_UNG_HO AS ct ON nuh.MaDotNhanUngHo = ct.MaDotNhanUngHo";
			PreparedStatement cmd= con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaDotNhanUngHo");
				String hodan = rs.getString("MaHoDan");
				Date ngay = rs.getDate("NgayNhanUngHo");
				String hinhthuc = rs.getString("HinhThucNhanUngHo");
				int soluong = rs.getInt("SoLuongNhanUngHo");
				NhanUngHoBEAN nuh = new NhanUngHoBEAN(ma, hodan, ngay, hinhthuc, soluong);
				list.add(nuh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	 }
	 
	 /*
	  * Xóa một đợt nhận ủng hộ
	  */
	public void deleteNUH(String ma) {
		try {
			con.KetNoi();
			String sql1 = "DELETE FROM CHI_TIET_DOT_NHAN_UNG_HO WHERE MaDotNhanUngHo=?";
			String sql2 = "DELETE FROM DOT_NHAN_UNG_HO WHERE MaDotNhanUngHo=?";
			PreparedStatement cmd1 = con.cn.prepareStatement(sql1);
			cmd1.setString(1, ma);
			cmd1.executeUpdate();
			
			PreparedStatement cmd2 = con.cn.prepareStatement(sql2);
			cmd2.setString(1, ma);
			cmd2.executeUpdate();
			
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
