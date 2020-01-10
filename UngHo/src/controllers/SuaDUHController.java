package controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DotUngHoBO;

/**
 * Servlet implementation class SuaDUHController
 */
@WebServlet("/SuaDUHController")
public class SuaDUHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDUHController() {
        super();
        // TODO Auto-generated constructor stub
    }
    DotUngHoBO duhBO = new DotUngHoBO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			if(request.getParameter("suaDotUngHo")!=null) {
				String madotungho = request.getParameter("madotungho");
				String madonviungho = request.getParameter("nguoiungho");
				
				String ngay = request.getParameter("ngayungho");
				java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
				Date ngayungho = new Date(d.getTime());
				
				String hinhhthuc = request.getParameter("hinhthuc");
				int soluong = Integer.parseInt(request.getParameter("soluong"));
				String donvi = request.getParameter("donvi");
				duhBO.changeDotUngHo(madotungho, madonviungho, ngayungho, hinhhthuc, soluong, donvi);
			}
			response.sendRedirect("DotUngHoController");
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
