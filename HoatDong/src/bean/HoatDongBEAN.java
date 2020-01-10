package bean;

import java.util.Date;

public class HoatDongBEAN {
	private String maHD;
	private String tenHD;
	private String moTaHD;
	private Date ngayGioBD;
	private Date ngayGioKT;
	private Date thoiHanDK;
	private int sLToiThieuYC;
	private int sLToiDaDK;
	private String trangThai;
	private String maTV;

	public HoatDongBEAN(String maHD, String tenHD, String moTaHD, Date ngayGioBD, Date ngayGioKT, Date thoiHanDK,
			int sLToiThieuYC, int sLToiDaDK, String trangThai, String maTV) {
		super();
		this.maHD = maHD;
		this.tenHD = tenHD;
		this.moTaHD = moTaHD;
		this.ngayGioBD = ngayGioBD;
		this.ngayGioKT = ngayGioKT;
		this.thoiHanDK = thoiHanDK;
		this.sLToiThieuYC = sLToiThieuYC;
		this.sLToiDaDK = sLToiDaDK;
		this.trangThai = trangThai;
		this.maTV = maTV;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getTenHD() {
		return tenHD;
	}

	public void setTenHD(String tenHD) {
		this.tenHD = tenHD;
	}

	public String getMoTaHD() {
		return moTaHD;
	}

	public void setMoTaHD(String moTaHD) {
		this.moTaHD = moTaHD;
	}

	public Date getNgayGioBD() {
		return ngayGioBD;
	}

	public void setNgayGioBD(Date ngayGioBD) {
		this.ngayGioBD = ngayGioBD;
	}

	public Date getNgayGioKT() {
		return ngayGioKT;
	}

	public void setNgayGioKT(Date ngayGioKT) {
		this.ngayGioKT = ngayGioKT;
	}

	public Date getThoiHanDK() {
		return thoiHanDK;
	}

	public void setThoiHanDK(Date thoiHanDK) {
		this.thoiHanDK = thoiHanDK;
	}

	public int getsLToiThieuYC() {
		return sLToiThieuYC;
	}

	public void setsLToiThieuYC(int sLToiThieuYC) {
		this.sLToiThieuYC = sLToiThieuYC;
	}

	public int getsLToiDaDK() {
		return sLToiDaDK;
	}

	public void setsLToiDaDK(int sLToiDaDK) {
		this.sLToiDaDK = sLToiDaDK;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaTV() {
		return maTV;
	}

	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

}
