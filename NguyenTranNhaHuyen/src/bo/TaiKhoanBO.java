package bo;

import bean.TaiKhoanBEAN;
import dao.TaiKhoanDAO;

/**
 * TaiKhoanBO
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
public class TaiKhoanBO {
	public TaiKhoanBEAN kTDangNhap(String adname, String pass) throws Exception{
		TaiKhoanDAO tk=new TaiKhoanDAO();
		return tk.kTDangNhap(adname, pass);
	}
}
