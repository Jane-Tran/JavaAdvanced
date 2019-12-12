package tranVanQuangHuy.bean;


public class hangbean {
	private String mahang;
	private String tenhang;
	private String nhacungcap;
	private int soluong;
	private String gia;
	private String anh;
	public hangbean(String mahang, String tenhang, String nhacungcap, int soluong, String gia, String anh) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.nhacungcap = nhacungcap;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public String getNhacungcap() {
		return nhacungcap;
	}
	public void setNhacungcap(String nhacungcap) {
		this.nhacungcap = nhacungcap;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
