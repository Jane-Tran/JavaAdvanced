package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.BenhNhanBEAN;
import dao.BenhNhanDAO;

/**
 * BenhNhanBO
 * 
 * Date: 15-12-2018
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * -------------------------------------
 * 15-12-2018	NhaHuyen		Create
 */
public class BenhNhanBO {
	BenhNhanDAO bn=new BenhNhanDAO();
	public ArrayList<BenhNhanBEAN> ds;
	public ArrayList<BenhNhanBEAN> getBenhNhan() throws Exception{
		return bn.getBenhNhan();
	}
	public int themBenhNhan(String patientID, String patientName, String sex, Date birthDay, String address,String phoneNumber) throws Exception {
		return bn.themBenhNhan(patientID, patientName, sex, birthDay, address, phoneNumber);
	}

}
