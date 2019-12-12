package model.bo;

import java.util.ArrayList;

import model.bean.giohangbean;

public class giohangbo {
	
	ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	
	public void Add(String masach, String tensach, String anh, long gia, long soluong) {
		ds.add(new giohangbean(masach,tensach,anh, gia,soluong));
		ArrayList<giohangbean> dsgh = new ArrayList<giohangbean>();
		int flagTheFirst = 0;
		for(giohangbean dsgio: ds) {
			if(flagTheFirst == 0) {
				dsgh.add(dsgio);
				flagTheFirst = 1;
			}else {
				int flagTheFirstFind = 0;
				for(giohangbean dsghtemps: ds) {
					if(dsghtemps.getMasach().equals(dsgio.getMasach())) {
						flagTheFirstFind = 1;
						dsghtemps.setSoluong(dsghtemps.getSoluong()+1);
						dsghtemps.setThanhtien(dsghtemps.getGia()*dsghtemps.getSoluong());
					}
				}
				if(flagTheFirstFind == 0) {
					dsgh.add(dsgio);
				}
				
			}
		}
		ds=dsgh;
	}
	public Long Sum() {
		long s=0;
		for (giohangbean sach:ds) {
			s+=sach.getThanhtien();
		}
		return s;
	}
	public int Count(){
		System.out.println(ds.size());
		return ds.size();
	}
	public ArrayList<giohangbean> GetListgiohang(ArrayList<giohangbean> gh){
		return ds; 
	}
}
