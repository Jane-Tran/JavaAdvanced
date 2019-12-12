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
	//Lấy toàn bộ sách
	public ArrayList<sachbean> getSach(){
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		try {
			ConnectSQL con = new ConnectSQL();
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
	
	public ArrayList<sachbean> getSach(String ml){
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		try {
			ConnectSQL con = new ConnectSQL();
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
