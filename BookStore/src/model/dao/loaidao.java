package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bean.loaibean;

public class loaidao {
	ConnectSQL con = new ConnectSQL();
	public boolean KtTrungMa(String maloai) throws Exception {
		//Kiem tra xem co maloai nay trong bang loai hay ko?
	
			String sql = "SELECT maloai FROM loai WHERE maloai=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			ResultSet rs = cmd.executeQuery();
			boolean kt = rs.next();
			rs.close();
			return kt;
	}
	
	public int Them(String maloai, String tenloai) throws Exception {
		con.KetNoi();
		//Neu trung ma thi khong them
		if(KtTrungMa(maloai)) return 0;
		//Thiet lap cau lenh sql
		String sql = "INSERT INTO loai(maloai,tenloai) VALUES (?,?)";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}
	
	public boolean KtLoaiSach(String maloai) throws Exception {
		//Kiem tra xem ma loai nay co sach hay khong
		String sql = "SELECT masach FROM sach WHERE masach=?";
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kt = rs.next();
		rs.close();
		return kt;
	}
	
	public int Xoa(String maloai) throws Exception {
		con.KetNoi();
		//Xoa loai khong co sach
		if(KtLoaiSach(maloai)) return 0;
		//Thuc hien Xoa
		//Thiet lap cau lenh sql
		String sql = "DELETE FROM loai WHERE maloai=?";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}

	
	public int Sua(String maloai, String tenloaimoi) throws Exception {
		con.KetNoi();
		//Sua theo ten loai
		String sql = "UPDATE loai SET  tenloai=? WHERE maloai=?";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, tenloaimoi);
		cmd.setString(2, maloai);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}
	
	public ArrayList<loaibean> getLoai(){
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM loai";
			
			/*PreparedStatement dùng để thực hiện truy vấn tham số
			 * Cải thiện hiệu suất vì truy vấn chỉ được biên dịch một lần
			 */
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			
			/*ResultSet là 1 đối tượng, nó duy trì một con trỏ đến một trong bảng dữ liệu
			 * 
			 */
			ResultSet rs = cmd.executeQuery();//executeQuery() là một phương thức của PreparedStatement
			while(rs.next()) {//trỏ đến hàng tiếp theo 
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				loaibean s = new loaibean(maloai, tenloai);
				ds.add(s);
			}
			con.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
}
