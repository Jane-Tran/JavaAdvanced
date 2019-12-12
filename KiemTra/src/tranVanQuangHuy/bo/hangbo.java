package tranVanQuangHuy.bo;

import java.util.ArrayList;

import tranVanQuangHuy.bean.hangbean;
import tranVanQuangHuy.dao.hangdao;

public class hangbo {
	hangdao h=new hangdao();
	ArrayList<hangbean> ds;
	public ArrayList<hangbean> getHang(){
		ds=h.getHang();
		return h.getHang();
	}
	public ArrayList<hangbean> timkey(String key){
		key=key.toLowerCase();
		ArrayList<hangbean>tam=new ArrayList<hangbean>();
		for(hangbean h: ds) {
			if(h.getTenhang().toLowerCase().trim().contains(key)||
			   h.getNhacungcap().toLowerCase().trim().contains(key)||
			   h.getMahang().toLowerCase().trim().contains(key))
				tam.add(h);
		}
		return tam;
	}
}
