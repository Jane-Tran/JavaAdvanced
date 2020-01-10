package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.ThongKeBEAN;

public class ThongKeDAO {
	ConnectDb con = new ConnectDb();
	
	public ArrayList<ThongKeBEAN> getListThongKe(){
		ArrayList<ThongKeBEAN> list = new ArrayList<ThongKeBEAN>();
		try {
			con.KetNoi();
			String sql = "SELECT hd.MaHoDan, hd.HoTenChuHo,hd.KhoiHoacThon,hd.ToHoacDoi, hd.LaHoNgheo, sum(ct.SoLuongNhanUngHo )AS TongTienMat\r\n" + 
					"FROM HO_DAN AS hd JOIN DOT_NHAN_UNG_HO AS nuh ON hd.MaHoDan = nuh.MaHoDan\r\n" + 
					"					JOIN CHI_TIET_DOT_NHAN_UNG_HO AS ct ON ct.MaDotNhanUngHo = nuh.MaDotNhanUngHo\r\n" + 
					"WHERE ct.HinhThucNhanUngHo = ?\r\n" + 
					"GROUP BY hd.MaHoDan, hd.HoTenChuHo, hd.ToHoacDoi,  hd.KhoiHoacThon, hd.LaHoNgheo\r\n" + 
					"ORDER BY TongTienMat DESC";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, "Tien mat");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaHoDan");
				String ten = rs.getString("HoTenChuHo");
				String to = rs.getString("ToHoacDoi");
				String khoi = rs.getString("KhoiHoacThon");
				String ngheo = rs.getString("LaHoNgheo");
				int tong = rs.getInt("TongTienMat");
				ThongKeBEAN tk  = new ThongKeBEAN(ma, ten, to, khoi, ngheo, tong);
				list.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
