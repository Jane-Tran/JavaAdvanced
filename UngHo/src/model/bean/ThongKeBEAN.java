package model.bean;

public class ThongKeBEAN {
	private String MaHoDan;
	private String HoTenChuHo;
	private String To;
	private String Khoi;
	private String LaHoNgheo;
	private int TongTien;
	public ThongKeBEAN(String maHoDan, String hoTenChuHo, String to, String khoi, String laHoNgheo, int tongTien) {
		super();
		MaHoDan = maHoDan;
		HoTenChuHo = hoTenChuHo;
		To = to;
		Khoi = khoi;
		LaHoNgheo = laHoNgheo;
		TongTien = tongTien;
	}
	public String getMaHoDan() {
		return MaHoDan;
	}
	public void setMaHoDan(String maHoDan) {
		MaHoDan = maHoDan;
	}
	public String getHoTenChuHo() {
		return HoTenChuHo;
	}
	public void setHoTenChuHo(String hoTenChuHo) {
		HoTenChuHo = hoTenChuHo;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getKhoi() {
		return Khoi;
	}
	public void setKhoi(String khoi) {
		Khoi = khoi;
	}
	public String getLaHoNgheo() {
		return LaHoNgheo;
	}
	public void setLaHoNgheo(String laHoNgheo) {
		LaHoNgheo = laHoNgheo;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	

}
