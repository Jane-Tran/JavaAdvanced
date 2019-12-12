package tranVanQuangHuy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tranVanQuangHuy.bean.hangbean;



public class hangdao {
	public ArrayList<hangbean> getHang(){
		ArrayList<hangbean> ds= new ArrayList<hangbean>();
		try {
			ConnectSQL dst=new ConnectSQL();
			dst.KetNoi();
			String sql="select * from huy";
			PreparedStatement cmd=dst.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				String mahang=rs.getString("mahang");
				String tenhang=rs.getString("tenhang");
				String nhacungcap=rs.getString("nhacungcap");
				int soluong=rs.getInt("soluong");
				String gia=rs.getString("gia");
				String anh=rs.getString("anh");
				hangbean h= new hangbean(mahang, tenhang, nhacungcap, soluong, gia, anh);
				ds.add(h);
			}
			dst.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
}
}
