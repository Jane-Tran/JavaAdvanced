package model.bo;

import java.util.ArrayList;

import model.bean.NhanUngHoBEAN;
import model.dao.NhanUngHoDAO;

public class NhanUngHoBO {
	NhanUngHoDAO nuhDAO = new NhanUngHoDAO();
	
	public ArrayList<NhanUngHoBEAN> getListNUH(){
		return nuhDAO.getListNUH();
	}
	
	public void deleteNUH(String ma) {
		nuhDAO.deleteNUH(ma);
	}
}
