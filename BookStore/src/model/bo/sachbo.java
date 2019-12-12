package model.bo;

import java.util.ArrayList;

import model.bean.sachbean;
import model.dao.sachdao;

public class sachbo {
	sachdao s = new sachdao();
	ArrayList<sachbean> ds;
	//Lấy toàn bộ  sách trong bộ nhớ 
	public ArrayList<sachbean> getSach(){
		ds = s.getSach();
		return s.getSach();
	}
	//Lấy sách theo mã loại trong bộ nhớ
	public ArrayList<sachbean> getSach(String ml){
		return s.getSach(ml);
	}
	//Lọc các sách cùng loại
	public ArrayList<sachbean> timsach(String maloai){
		ArrayList<sachbean>tam=new ArrayList<sachbean>();
		for(sachbean s: ds) {
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		}
		return tam;
	}
	//Tìm kiếm sách với tên sách hoặc tên tác giả gần đúng
	public ArrayList<sachbean> timkey(String key){
		key=key.toLowerCase();
		ArrayList<sachbean>tam=new ArrayList<sachbean>();
		for(sachbean s: ds) {
			if(s.getTensach().toLowerCase().contains(key)||s.getTacgia().toLowerCase().contains(key))
				tam.add(s);
		}
		return tam;
	}
}
