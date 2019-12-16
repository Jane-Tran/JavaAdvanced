package model.bo;

import java.util.ArrayList;

import model.bean.hoadonbean;
import model.dao.hoadondao;

public class hoadonbo {
	hoadondao hdd = new hoadondao();
	ArrayList<hoadonbean> dshd;
	//Lấy toàn bộ hóa đơn 
	public ArrayList<hoadonbean> getHoaDon(){
		dshd = hdd.getHoaDon();
		return hdd.getHoaDon();
	}
	//Lấy hóa đơn của một khách hàng
	public ArrayList<hoadonbean> getHoaDon(String makh){
		//dshd = hdd.getHoaDon(makh);
		return hdd.getHoaDon(makh);
	}
	// Xác nhân hóa đơn đã thanh toán
	public int confirm(String mahoadon ) throws Exception {
		return hdd.confirm(mahoadon);
	}
	
	
}
