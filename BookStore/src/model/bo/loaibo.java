package model.bo;

import java.util.ArrayList;

import model.bean.loaibean;
import model.dao.loaidao;

public class loaibo {
	loaidao l = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getLoai(){
		ds = l.getLoai();
		return l.getLoai();
	}
	
	public int Them(String maloai, String tenloai) throws Exception {
		return l.Them(maloai, tenloai);
	}
	
	public int Sua(String maloai, String tenloaimoi) throws Exception {
		return l.Sua(maloai, tenloaimoi);
	}
	
	public int Xoa(String maloai) throws Exception {
		return l.Xoa(maloai);
	}
	
	public loaibean chon(String maloai) throws Exception{
		for (loaibean loai: l.getLoai()) {
			if(loai.getMaloai().equals(maloai))
				return loai;
		}
		return null;
	}
}
