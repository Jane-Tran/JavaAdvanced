package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.BacSyBEAN;
import dao.BacSyDAO;

/**
 * BacSyBO
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
public class BacSyBO {
	BacSyDAO bn=new BacSyDAO();
	public ArrayList<BacSyBEAN> ds;
	public ArrayList<BacSyBEAN> getBacSy() throws Exception{
		return bn.getBacSy();
	}
}
