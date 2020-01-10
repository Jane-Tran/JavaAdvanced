package model.bean;

import java.sql.Date;

public class NhanUngHoBEAN {
	private String MaDotNhanUngHo;
	private String MaHoDan;
	private Date NgayNhanUngHo;
	private String HinhThucNhanUngHo;
	private int SoLuongNhanUngHo;
	public NhanUngHoBEAN(String maDotNhanUngHo, String maHoDan, Date ngayNhanUngHo, String hinhThucNhanUngHo,
			int soLuongNhanUngHo) {
		super();
		MaDotNhanUngHo = maDotNhanUngHo;
		MaHoDan = maHoDan;
		NgayNhanUngHo = ngayNhanUngHo;
		HinhThucNhanUngHo = hinhThucNhanUngHo;
		SoLuongNhanUngHo = soLuongNhanUngHo;
	}
	public String getMaDotNhanUngHo() {
		return MaDotNhanUngHo;
	}
	public void setMaDotNhanUngHo(String maDotNhanUngHo) {
		MaDotNhanUngHo = maDotNhanUngHo;
	}
	public String getMaHoDan() {
		return MaHoDan;
	}
	public void setMaHoDan(String maHoDan) {
		MaHoDan = maHoDan;
	}
	public Date getNgayNhanUngHo() {
		return NgayNhanUngHo;
	}
	public void setNgayNhanUngHo(Date ngayNhanUngHo) {
		NgayNhanUngHo = ngayNhanUngHo;
	}
	public String getHinhThucNhanUngHo() {
		return HinhThucNhanUngHo;
	}
	public void setHinhThucNhanUngHo(String hinhThucNhanUngHo) {
		HinhThucNhanUngHo = hinhThucNhanUngHo;
	}
	public int getSoLuongNhanUngHo() {
		return SoLuongNhanUngHo;
	}
	public void setSoLuongNhanUngHo(int soLuongNhanUngHo) {
		SoLuongNhanUngHo = soLuongNhanUngHo;
	}
	
}
