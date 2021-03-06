package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.bean.sachbean;
import model.dao.sachdao;

public class sachbo {
	sachdao s = new sachdao();
	ArrayList<sachbean> ds;

	// Lấy toàn bộ sách trong bộ nhớ
	public ArrayList<sachbean> getSach() {
		ds = s.getSach();
		return s.getSach();
	}

	// Lấy sách theo mã loại trong bộ nhớ
	public ArrayList<sachbean> getSach(String ml) {
		return s.getSach(ml);
	}

	// Lọc các sách cùng loại
	public ArrayList<sachbean> timsach(String maloai) {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getMaloai().equals(maloai))
				tam.add(s);
		}
		return tam;
	}

	// Tìm kiếm sách với tên sách hoặc tên tác giả gần đúng
	public ArrayList<sachbean> timkey(String key) {
		key = key.toLowerCase();
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getTensach().toLowerCase().contains(key) || s.getTacgia().toLowerCase().contains(key))
				tam.add(s);
		}
		return tam;
	}

	// Thêm sách mới
	public int Them(String masach, String tensach, long soluong, long gia, String maloai, String sotap, String anh,
			Date ngaynhap, String tacgia) throws Exception {
		return s.Them(masach, tensach, soluong, gia, maloai, sotap, anh, ngaynhap, tacgia);
	}

	// Sửa các thông tin của sách theo mã sách
	public int Sua(String masach, String tensach, long soluong, long gia, String maloai, String sotap, String anh,
			Date ngaynhap, String tacgia) throws Exception {
		return s.Sua(masach, tensach, soluong, gia, maloai, sotap, anh, ngaynhap, tacgia);
	}

	// Xóa sách không thuộc Chi tiết hóa đơn nào
	public int Xoa(String masach) throws Exception {
		return s.Xoa(masach);
	}

	/**
	 * Chọn sách để tiến hành sửa
	 * 
	 * @param masach
	 * @return
	 * @throws Exception
	 */
	public sachbean Chon(String masach) throws Exception {
		for (sachbean sach : s.getSach()) {
			if (sach.getMasach().equals(masach))
				return sach;
		}
		return null;
	}
}
