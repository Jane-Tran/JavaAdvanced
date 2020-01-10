package model.bo;

import java.util.ArrayList;

import model.bean.ThongKeBEAN;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO tkDAO = new ThongKeDAO();
	
	public ArrayList<ThongKeBEAN> getListThongKe() throws Exception{
		return tkDAO.getListThongKe();
	}
}
