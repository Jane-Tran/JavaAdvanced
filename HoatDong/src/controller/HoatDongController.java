package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HoatDongBEAN;
import bean.ThongKeBEAN;
import bo.HoatDongBO;
import bo.ThongKeBO;

/**
 * Servlet implementation class HoatDongController
 */
@WebServlet("/HoatDongController")
public class HoatDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HoatDongBO hdBO = new HoatDongBO();
	ThongKeBO tkBO = new ThongKeBO();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HoatDongController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<HoatDongBEAN> ds = hdBO.getListHoatDong();
		request.setAttribute("ds", ds);
		
		ArrayList<ThongKeBEAN> tk  =tkBO.getListThongKe();
		request.setAttribute("tk", tk);
		
		request.getRequestDispatcher("HoatDong.jsp").forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("DeleteHoatDong") != null) {
			String ma = request.getParameter("DeleteMaHD");
			hdBO.deleteHoatDong(ma);
		}
		if (request.getParameter("addHoatDong") != null) {
			try {
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
				String maHD = request.getParameter("addMaHD");
				String tenHD = request.getParameter("addTenHD");
				String moTaHD = request.getParameter("addMoTaHD");
				Date ngayGioBD = ft.parse(request.getParameter("addNgayGioBD"));
				Date ngayGioKT = ft.parse(request.getParameter("addNgayGioKT"));
				Date thoiHanDK = ft2.parse(request.getParameter("addThoiHanDK"));
				int sLToiThieuYC = Integer.parseInt(request.getParameter("addSLToiThieuYC"));
				int sLToiDaDK = Integer.parseInt(request.getParameter("addSLToiDaYC"));
				String maTV = request.getParameter("addMaTV");
				HoatDongBEAN hoatdong = new HoatDongBEAN(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, thoiHanDK,
						sLToiThieuYC, sLToiDaDK, null, maTV);
				hdBO.addHoatDong(hoatdong);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (request.getParameter("editHoatDong") != null) {
			try {
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
				String maHD = request.getParameter("editMaHD");
				String tenHD = request.getParameter("editTenHD");
				String moTaHD = request.getParameter("editMoTaHD");
				Date ngayGioBD = ft.parse(request.getParameter("editNgayGioBD"));
				Date ngayGioKT = ft.parse(request.getParameter("editNgayGioKT"));
				Date thoiHanDK = ft2.parse(request.getParameter("editThoiHanDK"));
				int sLToiThieuYC = Integer.parseInt(request.getParameter("editSLToiThieuYC"));
				int sLToiDaDK = Integer.parseInt(request.getParameter("editSLToiDaYC"));
				String trangThai = request.getParameter("editTrangThai");
				String maTV = request.getParameter("editMaTV");
				HoatDongBEAN hoatdong = new HoatDongBEAN(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, thoiHanDK,
						sLToiThieuYC, sLToiDaDK, trangThai, maTV);
				String tb = hdBO.editHoatDong(hoatdong);
				System.out.println(tb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		response.sendRedirect("HoatDongController");
	}

}
