package model.bo;

import java.sql.Date;
import java.util.ArrayList;

import model.bean.DotUngHoBEAN;
import model.dao.DotUngHoDAO;

public class DotUngHoBO {
	
	DotUngHoDAO duh = new DotUngHoDAO();
	
	public boolean checkMaDotUngHo(String ma) throws Exception {
		return  duh.checkMaDotUngHo(ma);
	}
	
	public int addDotUngHo(String MaDotUngHo, String MaDVUH, Date NgayUngHo, String HinhThuc, int SoLuong, 
			String DonVi) throws Exception{
		return duh.addDotUngHo(MaDotUngHo, MaDVUH, NgayUngHo, HinhThuc, SoLuong, DonVi);
	}
	
	public ArrayList<DotUngHoBEAN> getListUH(){
		return duh.getListUH();
	}
	
	public void changeDotUngHo(String MaDotUngHo, String MaDVUH, Date NgayUngHo, String HinhThuc, int SoLuong, 
			String DonVi ) throws Exception {
		duh.changeDotUngHo(MaDotUngHo, MaDVUH, NgayUngHo, HinhThuc, SoLuong, DonVi);
	}
}
