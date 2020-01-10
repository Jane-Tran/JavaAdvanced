package bean;

public class ThongKeBEAN {
	private String maTV;
	private String hoTen;
	private float diemtrungbinh;

	public ThongKeBEAN(String maTV, String hoTen, float diemtrungbinh) {
		super();
		this.maTV = maTV;
		this.hoTen = hoTen;
		this.diemtrungbinh = diemtrungbinh;
	}

	public String getMaTV() {
		return maTV;
	}

	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemtrungbinh() {
		return diemtrungbinh;
	}

	public void setDiemtrungbinh(float diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}

}
