package bo;

import java.util.ArrayList;

import bean.ThongKeBEAN;
import dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO tkDAO  = new ThongKeDAO();
	
	public ArrayList<ThongKeBEAN> getListThongKe() {
		return tkDAO.getListThongKe();
	}
}
