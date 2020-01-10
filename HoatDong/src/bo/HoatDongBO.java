package bo;

import java.util.ArrayList;

import bean.HoatDongBEAN;
import dao.HoatDongDAO;

public class HoatDongBO {
	HoatDongDAO hdDAO = new HoatDongDAO();

	public ArrayList<HoatDongBEAN> getListHoatDong() {
		return hdDAO.getListHoatDong();

	}

	public boolean deleteHoatDong(String ma) {
		return hdDAO.deleteHoatDong(ma);
	}

	public String addHoatDong(HoatDongBEAN newHoatDong) {
		return hdDAO.addHoatDong(newHoatDong);
	}

	public String editHoatDong(HoatDongBEAN editHoatDong) {
		return hdDAO.editHoatDong(editHoatDong);
	}
}
