package model.bo;

import java.util.ArrayList;

import model.bean.giohangbean;

public class giohangbo {
	//Lưu thông tin trong bộ nhớ với ArrayList<giohangbean>
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	//Hàm thêm mới vào giỏ hàng và thay đổi sô lượng khi mặt hàng đã tồn tại
	//Tái sử dụng cho trường hợp cập số lượng 
	public void Add(String masach, String tensach, String anh, long gia, long soluong) {
		if(ds.isEmpty())
			ds.add(new giohangbean(masach,tensach,anh, gia,soluong));
		else {
			int flag =0;
			for(giohangbean dsi: ds) {
				if(dsi.getMasach().equals(masach)) {
					dsi.setSoluong(dsi.getSoluong()+soluong);
					dsi.setThanhtien(dsi.getGia()*dsi.getSoluong());
					flag =1;
				}
			}
			if(flag == 0)
				ds.add(new giohangbean(masach,tensach,anh, gia,soluong));
		}
	}
	
	//Hàm tính tổng tiền của tất cả
	public Long Sum() {
		long s=0;
		for (giohangbean sach:ds) {
			s+=sach.getThanhtien();
		}
		return s;
	}
	
	//Đếm số lượng của mỗi loại riêng biệt
	public int Count(){
		return ds.size();
	}
	public ArrayList<giohangbean> GetListgiohang(ArrayList<giohangbean> gh){
		return ds; 
	}
}
