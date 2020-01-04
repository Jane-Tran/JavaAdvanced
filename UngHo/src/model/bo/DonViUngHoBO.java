package model.bo;

import java.util.ArrayList;

import model.bean.DonViUngHoBEAN;
import model.dao.DonViUngHoDAO;

public class DonViUngHoBO {
	DonViUngHoDAO dvDAO = new DonViUngHoDAO();
	ArrayList<DonViUngHoBEAN> ds ;
	
	public ArrayList<DonViUngHoBEAN> getDVUH(){
		ds = dvDAO.getDVUH();
		return dvDAO.getDVUH();
	}
}
