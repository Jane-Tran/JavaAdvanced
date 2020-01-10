package model.bean;

import java.sql.Date;

public class DotUngHoBEAN {
	private String MaDotUngHo;
	private String MaDVUH;
	private String HoTenNguoiDaiDien;
	private Date NgayUngHo;
	private String HinhThucUngHo;
	private int SoLuongUngHo;
	private String DonViTinh;
	
	public DotUngHoBEAN(String maDotUngHo, String maDVUH, String hoTenNguoiDaiDien, Date ngayUngHo,
			String hinhThucUngHo, int soLuongUngHo, String donViTinh) {
		super();
		MaDotUngHo = maDotUngHo;
		MaDVUH = maDVUH;
		HoTenNguoiDaiDien = hoTenNguoiDaiDien;
		NgayUngHo = ngayUngHo;
		HinhThucUngHo = hinhThucUngHo;
		SoLuongUngHo = soLuongUngHo;
		DonViTinh = donViTinh;
	}
	
	public DotUngHoBEAN(String maDotUngHo, String hoTenNguoiDaiDien, Date ngayUngHo, String hinhThucUngHo, int soLuongUngHo,
			String donViTinh) {
		super();
		MaDotUngHo = maDotUngHo;
		HoTenNguoiDaiDien = hoTenNguoiDaiDien;
		NgayUngHo = ngayUngHo;
		HinhThucUngHo = hinhThucUngHo;
		SoLuongUngHo = soLuongUngHo;
		DonViTinh = donViTinh;
	}
	public String getMaDotUngHo() {
		return MaDotUngHo;
	}
	public void setMaDotUngHo(String maDotUngHo) {
		MaDotUngHo = maDotUngHo;
	}
	public String getMaDVUH() {
		return MaDVUH;
	}
	public void setMaDVUH(String maDVUH) {
		MaDVUH = maDVUH;
	}
	public String getHoTenNguoiDaiDien() {
		return HoTenNguoiDaiDien;
	}
	public void setHoTenNguoiDaiDien(String hoTenNguoiDaiDien) {
		HoTenNguoiDaiDien = hoTenNguoiDaiDien;
	}
	public Date getNgayUngHo() {
		return NgayUngHo;
	}
	public void setNgayUngHo(Date ngayUngHo) {
		NgayUngHo = ngayUngHo;
	}
	public String getHinhThucUngHo() {
		return HinhThucUngHo;
	}
	public void setHinhThucUngHo(String hinhThucUngHo) {
		HinhThucUngHo = hinhThucUngHo;
	}
	public int getSoLuongUngHo() {
		return SoLuongUngHo;
	}
	public void setSoLuongUngHo(int soLuongUngHo) {
		SoLuongUngHo = soLuongUngHo;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	

}
