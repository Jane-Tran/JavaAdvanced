package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.giohangbean;


public class giohangdao{
	ConnectSQL con = new ConnectSQL();
	public int checkout(String mkh, ArrayList<giohangbean> ghb) throws Exception {
		con.KetNoi();
		
		//Lấy id lớn nhất của bảng hóa đơn
		PreparedStatement cmd1 = con.cn.prepareStatement("SELECT MAX(Mahoadon) FROM hoadon");
		ResultSet maxHoaDon   =  cmd1.executeQuery();
		maxHoaDon.next();
		
		//Chèn dữ liệu vào bảng hóa đơn 
		String sqlInsertHoaDon= "INSERT INTO hoadon(MaHoaDon,makh,NgayMua,damua) VALUES(?,?,?,?)";
		PreparedStatement cmd2 = con.cn.prepareStatement(sqlInsertHoaDon);
		cmd2.setInt(1, maxHoaDon.getInt(1)+1);
		cmd2.setInt(2, Integer.parseInt(mkh));
		cmd2.setDate(3,getCurrentDate());
		cmd2.setBoolean(4,false);
		int kt=cmd2.executeUpdate();
		
		//Xử lý thêm chi tiết hóa đơn sau khi đã thêm hóa đơn
		if(kt==1) {
			String sqlInsertChiTieHoaDon= "INSERT INTO ChiTietHoaDon(MaChiTietHD,MaSach,SoLuongMua,MaHoaDon) VALUES(?,?,?,?)";
			PreparedStatement cmd3 = con.cn.prepareStatement(sqlInsertChiTieHoaDon);
			
			//Giới hạn giá trị để batch
			final int batchSize = 1000;
			int count = 0;
			
			//Tìm giá trị lớn nhất của id ChiTietHD :(
			PreparedStatement cmd4 = con.cn.prepareStatement("SELECT MAX(MaChiTietHD) FROM ChiTietHoaDon");
			ResultSet maxChiTiet   =  cmd4.executeQuery();
			maxChiTiet.next();
			
			int a = maxChiTiet.getInt(1);
			//Chèn nhiều dòng vào csdl sử dụng Batch Update
			for(giohangbean sach:ghb) {
				cmd3.setInt(1, ++a);
				cmd3.setString(2, sach.getMasach());
				cmd3.setInt(3, (int)sach.getSoluong());
				cmd3.setInt(4,maxHoaDon.getInt(1)+1 );
				cmd3.addBatch();
				
				//Thực hiện executeBatch khi số hàng quá lớn
				if(++count % batchSize == 0) {
					cmd3.executeBatch();
				}
			}
			//Đóng cmd4
			maxChiTiet.close();
			cmd4.close();
			//Xong vòng lặp thì thực thi câu lệnh
			cmd3.executeBatch();
			kt=2;
			cmd3.close();
		}	
		//đóng và giải phóng con trỏ
		cmd1.close();
		cmd2.close();
		con.cn.close();
		return kt;
	}
	//Hàm lấy ngày hiện tại
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
//	public static void main(String[] args) {
//		//System.out.println(java.time.LocalDate.now()+" "+java.time.LocalTime.now());
//		System.out.println(getCurrentDate()); 
//	}
}
