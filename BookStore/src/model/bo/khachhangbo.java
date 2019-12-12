package model.bo;

import model.bean.khachhangbean;
import model.dao.khachhangdao;

public class khachhangbo {
	khachhangdao khd= new khachhangdao();
	public khachhangbean Authentication (String un, String pw) throws Exception {
		return khd.Authentication(un, pw) ;
	}

}
