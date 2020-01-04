package bo;

import java.util.ArrayList;

import bean.BenhAnNamBEAN;
import dao.BenhAnNamDAO;

/**
 * BenhAnNamBO
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
public class BenhAnNamBO {
	BenhAnNamDAO ban=new BenhAnNamDAO();
	public ArrayList<BenhAnNamBEAN> ds;
	public ArrayList<BenhAnNamBEAN> getBenhAnNam() throws Exception{
		return ban.getBenhAnNam();
	}
	public ArrayList<BenhAnNamBEAN> listBenhAnNam(int nam) throws Exception{
		return ban.listBenhAnNam(nam);
	}

}
