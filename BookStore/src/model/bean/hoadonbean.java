package model.bean;

import java.util.Date;

public class hoadonbean {
	private int mahoadon;
	private String makhachhang;
	private Date ngaymua;
	private boolean damua;
	public hoadonbean() {
		super();
	}

	public hoadonbean(int mahoadon, String makhachhang, Date ngaymua, boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.makhachhang = makhachhang;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}

	public hoadonbean(int mahoadon,  Date ngaymua, boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
}
