package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.DonViUngHoBEAN;

public class DonViUngHoDAO {
	ConnectDb con = new ConnectDb();

	public ArrayList<DonViUngHoBEAN> getDVUH() {
		ArrayList<DonViUngHoBEAN> ds = new ArrayList<DonViUngHoBEAN>();
		try {
			con.KetNoi();
			String sql = "SELECT MaDVUH, HoTenNguoiDaiDien FROM DON_VI_UNG_HO";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaDVUH");
				String ten = rs.getString("HoTenNguoiDaiDien");
				DonViUngHoBEAN dv = new DonViUngHoBEAN(ma, ten);
				ds.add(dv);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
