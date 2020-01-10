package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.HoatDongBEAN;

public class HoatDongDAO {
	ConnectDB con = new ConnectDB();

	/**
	 * get list Hoat dong
	 * 
	 * @return
	 */
	public ArrayList<HoatDongBEAN> getListHoatDong() {
		ArrayList<HoatDongBEAN> ds = new ArrayList<HoatDongBEAN>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM HOATDONG";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("MaHD");
				String tenHD = rs.getString("TenHD");
				String moTaHD = rs.getString("MoTaHD");
				Date ngayGioBD = rs.getTimestamp("NgayGioBD");
				Date ngayGioKT = rs.getTimestamp("NgayGioKT");
				Date thoiHanDK = rs.getDate("ThoiHanDK");
				int sLToiThieuYC = rs.getInt("SLToiThieuYC");
				int sLToiDaDK = rs.getInt("SLToiDaYC");
				String trangThai = rs.getString("TrangThai");
				String maTV = rs.getString("MaTV");

				HoatDongBEAN hd = new HoatDongBEAN(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, thoiHanDK, sLToiThieuYC,
						sLToiDaDK, trangThai, maTV);
				ds.add(hd);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	/**
	 * Add new HoatDong
	 * 
	 * @param newHoatDong
	 * @return
	 */
	public String addHoatDong(HoatDongBEAN newHoatDong) {
		try {
			con.KetNoi();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd ");
			String sql = "INSERT INTO HOATDONG(MaHD,TenHD, MoTaHD, NgayGioBD, NgayGioKT, ThoiHanDK, SLToiThieuYC, SLToiDaYC, TrangThai, MaTV, LyDoHuyHd)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, N'Đang mời đăng kí', ?,'null')";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, newHoatDong.getMaHD());
			cmd.setString(2, newHoatDong.getTenHD());
			cmd.setString(3, newHoatDong.getMoTaHD());
			cmd.setString(4, ft.format(newHoatDong.getNgayGioBD()));
			cmd.setString(5, ft.format(newHoatDong.getNgayGioKT()));
			cmd.setString(6, ft2.format(newHoatDong.getThoiHanDK()));
			cmd.setInt(7, newHoatDong.getsLToiThieuYC());
			cmd.setInt(8, newHoatDong.getsLToiDaDK());
			cmd.setString(9, newHoatDong.getMaTV());
			cmd.executeUpdate();
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "Loi o ham them";
		}

	}

	/**
	 * Edit a HoatDong
	 * 
	 * @param editHoatDong
	 * @return
	 */
	public String editHoatDong(HoatDongBEAN editHoatDong) {
		try {
			con.KetNoi();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd ");
			String sql = "UPDATE HOATDONG SET TenHD =?, MoTaHD =?, NgayGioBD=?, NgayGioKT=?, ThoiHanDK=?, SLToiThieuYC=?, SLToiDaYC=?, TrangThai=?, MaTV=?"
					+ " WHERE MaHD=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(10, editHoatDong.getMaHD());
			cmd.setString(1, editHoatDong.getTenHD());
			cmd.setString(2, editHoatDong.getMoTaHD());
			cmd.setString(3, ft.format(editHoatDong.getNgayGioBD()));
			cmd.setString(4, ft.format(editHoatDong.getNgayGioKT()));
			cmd.setString(5, ft2.format(editHoatDong.getThoiHanDK()));
			cmd.setInt(6, editHoatDong.getsLToiThieuYC());
			cmd.setInt(7, editHoatDong.getsLToiDaDK());
			cmd.setString(8, editHoatDong.getTrangThai());
			cmd.setString(9, editHoatDong.getMaTV());
			cmd.executeUpdate();
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "Loi o ham sua";
		}

	}

	/**
	 * Delete a HoatDong
	 * 
	 * @param ma
	 */
	public boolean deleteHoatDong(String ma) {
		try {
			con.KetNoi();
			String sql1 = "DELETE FROM THAMGIA WHERE MaHD=?";
			String sql2 = "DELETE FROM HOATDONG WHERE MaHD=?";
			PreparedStatement cmd1 = con.cn.prepareStatement(sql1);
			cmd1.setString(1, ma);
			cmd1.executeUpdate();

			PreparedStatement cmd2 = con.cn.prepareStatement(sql2);
			cmd2.setString(1, ma);
			cmd2.executeUpdate();

			con.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
