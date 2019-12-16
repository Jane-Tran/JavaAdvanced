package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.bean.sachbean;


/*
 * Hàm kết nối và lấy danh sách Sách từ CSDL
 * Trả về là danh sách đối tượng sachbean được lưu vào mảng động ArrayList
 */
public class sachdao {
	ConnectSQL con = new ConnectSQL();
	public boolean KtTrungMa(String masach) throws Exception {
		//Kiem tra xem co masach nay trong bang sach hay ko?
			String sql = "SELECT masach FROM sach WHERE masach=?";
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			ResultSet rs = cmd.executeQuery();
			boolean kt = rs.next();
			rs.close();
			return kt;
	}
	
	public int Them(String masach, String tensach, long soluong, long gia, String maloai, String sotap, String anh,
			Date ngaynhap, String tacgia) throws Exception {
		con.KetNoi();
		//Neu trung ma thi khong them
		if(KtTrungMa(masach)) return 0;
		//Thiet lap cau lenh sql
		String sql = "INSERT INTO sach(masach,tensach,soluong,gia,maloai,sotap,anh,NgayNhap,tacgia) VALUES (?,?,?,?,?,?,?,?,?)";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, maloai);
		cmd.setString(6, sotap);
		cmd.setString(7, anh);
		cmd.setDate(8, (java.sql.Date)ngaynhap);
		cmd.setString(9, tacgia);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}
	
	public boolean KtSachCoThuocHoaDon(String masach) throws Exception {
		//Kiem tra xem ma sach nay co thuoc hoa don nao khong
		String sql = "SELECT MaSach FROM ChiTietHoaDon WHERE MaSach=?";
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		boolean kt = rs.next();
		rs.close();
		return kt;
	}
	
	public int Xoa(String masach) throws Exception {
		con.KetNoi();
		//Xoa sach khong thuoc hoa don nao
		if(KtSachCoThuocHoaDon(masach)) return 0;
		//Thuc hien Xoa
		//Thiet lap cau lenh sql
		String sql = "DELETE FROM sach WHERE masach=?";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}

	
	public int Sua(String masach, String tensach, long soluong, long gia, String maloai, String sotap, String anh,
			Date ngaynhap, String tacgia) throws Exception {
		con.KetNoi();
		//Sua theo ten loai
		String sql = "UPDATE sach SET  tensach=?, soluong=?, gia=?, maloai=?, sotap=?, anh=?, NgayNhap=?, tacgia=? WHERE masach=?";
		//Cho thuc hien cau lenh
		PreparedStatement cmd = con.cn.prepareStatement(sql);
		cmd.setString(1, tensach);
		cmd.setLong(2, soluong);
		cmd.setLong(3, gia);
		cmd.setString(4, maloai);
		cmd.setString(5, sotap);
		cmd.setString(6, anh);
		cmd.setDate(7, (java.sql.Date)ngaynhap);
		cmd.setString(8, tacgia);
		cmd.setString(9, masach);
		int kt=cmd.executeUpdate();
		cmd.close();
		con.cn.close();
		return kt;
	}
	//Lấy toàn bộ sách
	public ArrayList<sachbean> getSach(){
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM sach";
			
			/*PreparedStatement dùng để thực hiện truy vấn tham số
			 * Cải thiện hiệu suất vì truy vấn chỉ được biên dịch một lần
			 */
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			
			/*ResultSet là 1 đối tượng, nó duy trì một con trỏ đến một trong bảng dữ liệu
			 * 
			 */
			ResultSet rs = cmd.executeQuery();//executeQuery() là một phương thức của PreparedStatement
			while(rs.next()) {//trỏ đến hàng tiếp theo 
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				String anh = rs.getString("anh");
				Date ngaynhap = rs.getDate("NgayNhap");
				String tacgia = rs.getString("tacgia");
				sachbean s = new sachbean(masach, tensach,soluong, gia, maloai, sotap, anh, ngaynhap, tacgia);
				ds.add(s);
			}
			con.cn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<sachbean> getSach(String ml){
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		try {
			con.KetNoi();
			String sql = "SELECT * FROM sach WHERE sach.maloai=?";
			
			/*PreparedStatement dùng để thực hiện truy vấn tham số
			 * Cải thiện hiệu suất vì truy vấn chỉ được biên dịch một lần
			 */
			PreparedStatement cmd = con.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			/*ResultSet là 1 đối tượng, nó duy trì một con trỏ đến một trong bảng dữ liệu
			 * 
			 */
			ResultSet rs = cmd.executeQuery();//executeQuery() là một phương thức của PreparedStatement
			while(rs.next()) {//trỏ đến hàng tiếp theo 
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				Date ngaynhap = rs.getDate("NgayNhap");
				String maloai = rs.getString("maloai");
				sachbean s = new sachbean(masach, tensach, tacgia, gia, anh, ngaynhap, maloai);
				ds.add(s);
			}
			con.cn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
