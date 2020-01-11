package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ThongKeBEAN;

public class ThongKeDAO {
	ConnectDB con = new ConnectDB();

	/**
	 * get list ThongKe
	 * 
	 * @return
	 */
	public ArrayList<ThongKeBEAN> getListThongKe() {
		ArrayList<ThongKeBEAN> ds = new ArrayList<ThongKeBEAN>();
		try {
			con.KetNoi();
//			String sql = "SELECT * FROM VIEW_DiemTrungBinh";
//			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = con.getBang("VIEW_DiemTrungBinh"); //cmd.executeQuery();
			while (rs.next()) {
				String maTv = rs.getString("MaTV");
				String hoTen = rs.getString("HoTen");
				float diemTrungBinh = rs.getFloat("DiemTrungBinh");
				ThongKeBEAN tk = new ThongKeBEAN(maTv, hoTen, diemTrungBinh);
				ds.add(tk);
			}
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
