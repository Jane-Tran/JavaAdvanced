package bean;

/**
 * TaiKhoanBEAN
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
public class TaiKhoanBEAN {
	private String adname;
	private String pass;
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public TaiKhoanBEAN(String adname, String pass) {
		super();
		this.adname = adname;
		this.pass = pass;
	}
	public TaiKhoanBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
