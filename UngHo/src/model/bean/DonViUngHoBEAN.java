package model.bean;

public class DonViUngHoBEAN {
	 private String MaDVUH;
	 private String HoTenDVUH;
	public DonViUngHoBEAN(String maDVUH, String hoTenDVUH) {
		super();
		MaDVUH = maDVUH;
		HoTenDVUH = hoTenDVUH;
	}
	public String getMaDVUH() {
		return MaDVUH;
	}
	public void setMaDVUH(String maDVUH) {
		MaDVUH = maDVUH;
	}
	public String getHoTenDVUH() {
		return HoTenDVUH;
	}
	public void setHoTenDVUH(String hoTenDVUH) {
		HoTenDVUH = hoTenDVUH;
	}
	 
}
