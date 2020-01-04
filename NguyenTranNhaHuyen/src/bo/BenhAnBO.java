package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.BenhAnBEAN;
import dao.BenhAnDAO;

/**
 * BenhAnBO
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
public class BenhAnBO {
	BenhAnDAO ba=new BenhAnDAO();
	public ArrayList<BenhAnBEAN> ds;
	public ArrayList<BenhAnBEAN> getBenhAn() throws Exception{
		return ba.getBenhAn();
	}
	public ArrayList<BenhAnBEAN> getBenhAnTheoBacSy(String doctorID) throws Exception{
		return ba.getBenhAnTheoBacSy(doctorID);
	}
	public boolean xoaBenhAn(String patientID, String doctorID, Date examineDate) throws Exception{
		return ba.xoaBenhAn(patientID, doctorID, examineDate);
	}

}
