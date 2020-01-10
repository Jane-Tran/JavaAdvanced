package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.bean.DotUngHoBEAN;

public class DotUngHoDAO {
	ConnectDb con =  new ConnectDb();
	
	/*
	 * Kiểm tra xem Mã đợt ửng hộ đã tồn tại hay chưa 
	 */
	public boolean checkMaDotUngHo(String ma)  {
		try {
			String sql = "SELECT MaDotUngHo FROM DOT_UNG_HO WHERE MaDotUngHo=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			boolean kt = rs.next();
			rs.close();
			return kt;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/*
	 * Thêm một đợt Ủng hộ mới cùng với chi tiết của đợt Ủng hộ đó
	 */
	public int addDotUngHo(String MaDotUngHo, String MaDVUH, Date NgayUngHo, String HinhThuc, int SoLuong, String DonVi ) throws Exception {
		con.KetNoi();
		int kt;
		String sql1 = "INSERT INTO DOT_UNG_HO(MaDotUngHo, MaDVUH, NgayUngHo) VALUES(?,?,?) ";
		String sql2 = "INSERT INTO CHI_TIET_DOT_UNG_HO(MaDotUngHo, HinhThucUngHo, SoLuongUngHo, DonViTinh) VALUES (?,?,?,?)";
		
		PreparedStatement cmd1  = con.cn.prepareStatement(sql1);
		cmd1.setString(1, MaDotUngHo);
		cmd1.setString(2,MaDVUH);
		cmd1.setDate(3, NgayUngHo);
		kt = cmd1.executeUpdate();
		cmd1.close();
		if(kt==1) {
			PreparedStatement cmd2 = con.cn.prepareStatement(sql2);
			cmd2.setString(1,MaDotUngHo);
			cmd2.setString(2, HinhThuc);
			cmd2.setInt(3, SoLuong);
			cmd2.setString(4, DonVi);
			kt = cmd2.executeUpdate();
		}
		return kt;
	}
	
	/*
	 * Lấy danh sách các đợt Ủng hộ
	 */
	public ArrayList<DotUngHoBEAN> getListUH(){
		ArrayList<DotUngHoBEAN> list = new ArrayList<DotUngHoBEAN>();
		try {
			con.KetNoi();
			String sql = "SELECT du.MaDotUngHo, du.MaDVUH, dv.HoTenNguoiDaiDien, du.NgayUngHo, ct.HinhThucUngHo, ct.SoLuongUngHo, ct.DonViTinh\r\n" + 
					"FROM DON_VI_UNG_HO AS dv JOIN DOT_UNG_HO AS du ON dv.MaDVUH = du.MaDVUH\r\n" + 
					"						JOIN CHI_TIET_DOT_UNG_HO AS ct ON du.MaDotUngHo = ct.MaDotUngHo";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaDotUngHo");
				String madv = rs.getString("MaDVUH");
				String ten = rs.getString("HoTenNguoiDaiDien");
				Date ngay = rs.getDate("NgayUngHo");
				String hinhthuc = rs.getString("HinhThucUngHo");
				int soluong = rs.getInt("SoLuongUngHo");
				String donvi = rs.getString("DonViTinh");
				DotUngHoBEAN duh = new DotUngHoBEAN(ma, madv, ten, ngay, hinhthuc, soluong, donvi);
				list.add(duh);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * Sửa một đơt Ủng hộ
	 */
	public void changeDotUngHo(String MaDotUngHo, String MaDVUH, Date NgayUngHo, String HinhThuc, int SoLuong, String DonVi ) {
		try {
			con.KetNoi();
			String sql1 = "UPDATE CHI_TIET_DOT_UNG_HO SET HinhThucUngHo=?, SoLuongUngHo=?, DonViTinh=? WHERE MaDotUngHo=?";
			PreparedStatement cmd1 = con.cn.prepareStatement(sql1);
			cmd1.setString(1, HinhThuc);
			cmd1.setInt(2, SoLuong);
			cmd1.setString(3, DonVi);
			cmd1.setString(4, MaDotUngHo);
			cmd1.executeUpdate();
			
			String sql2 = "UPDATE DOT_UNG_HO SET MaDVUH=?, NgayUngHo=? WHERE MaDotUngHo=?";
			PreparedStatement cmd2 = con.cn.prepareStatement(sql2);
			cmd2.setString(1,MaDVUH);
			cmd2.setDate(2, NgayUngHo);
			cmd2.setString(3, MaDotUngHo);
			cmd2.executeUpdate();
			
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
